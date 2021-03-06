package graph

import java.lang.IllegalStateException
import kotlin.collections.HashMap

/**
 * Find articulation/Critical edge in Connected component.
 * It helps to find single point of failure in network grid.
 * Trojan Algorithm
 */

/***
 * Steps
 * 1. Calculate discovery time of each node starting from root via DFS
 * 2. Get the bridge by checking which edge goes missing after dfs traversal
 *      and bridge is in direction from greater dfn vertex to smaller
 * 3. Calculate Low value for each vertex using formula
 *          low(u) = Math.min(dfn(u), min( low(child), dfn(backEdge))
 * 4. if(dfn(u) <= low(v) u is parent
 *         u is bridge    v is child
 */
class ArticulationPoint {

    private var dfn = 1
    private var dfnMap: HashMap<Int, Int> = HashMap()
    private var lowMap: HashMap<Int, Int> = HashMap()
    private var edgeSetAfterDfn = HashSet<String>()
    private var edgeSet = HashSet<String>()

    fun articulationPoint(adjList: HashMap<Int, ArrayList<Int>>, root: Int) {
        // Create edge list
        adjList.forEach {entrySet ->
            entrySet.value.forEach {
                val edge = "${entrySet.key} $it"
                if(!edgeSet.contains(edge))
                    edgeSet.add(edge)
            }
        }

        // create discovery
        dfnMap[root] = 1
        addDfn(adjList, root)

        val bEMap = backEdgeSet(adjList, edgeSet,edgeSetAfterDfn)

        //Sort the map by value in ascending ways and calculate Low of each vertex
        dfnMap.toList().sortedByDescending { (_,v) -> v }.toMap().forEach {

            var minLowChild = Int.MAX_VALUE
            adjList[it.key]?.forEach {
                if(lowMap.containsKey(it))
                     minLowChild = Math.min(minLowChild, lowMap[it]!!)
            }

            var minDfnBE = Int.MAX_VALUE
            bEMap[it.key]?.forEach {
                minDfnBE = Math.min(minDfnBE, dfnMap[it]!!)
            }


            lowMap[it.key] = Math.min(dfnMap[it.key]!!, Math.min(minLowChild, minDfnBE) )
        }

        // Check if(dfn(u) <= low(v))
        adjList.forEach{ entry ->
            if(entry.key == root && entry.value.size == 1 || (entry.value.size == 0)){
                // root with one children and leaf node will be not consider as articulation point
            }else {
                entry.value.forEach {
                    if (dfnMap[entry.key]!! <= lowMap[it]!!) {
                        println("${entry.key} is articulation point")
                        return
                    }
                }
            }

        }


    }

    private fun addDfn(adjList: HashMap<Int, ArrayList<Int>>, root: Int){
        adjList[root]?.forEach {
            if(!dfnMap.containsKey(it)) {
                dfnMap[it] = ++dfn
                val edge = "$root $it"
                if (!edgeSetAfterDfn.contains(edge))
                    edgeSetAfterDfn.add(edge)
                val ed = "$it $root"
                if (!edgeSetAfterDfn.contains(ed))
                    edgeSetAfterDfn.add(ed)
                addDfn(adjList, it)
            }
        }
    }

    private fun backEdgeSet(adjList: HashMap<Int, ArrayList<Int>>, edgeSet1: HashSet<String>, edgeSet2: HashSet<String>): HashMap<Int, ArrayList<Int>>{
        var backeEdgeMap = HashMap<Int, ArrayList<Int>>()
        edgeSet1.forEach {
            val edge = it.split(" ")
            if(edge.size != 2)
                throw IllegalStateException()
            if(!edgeSet2.contains(it)) {
                val vt1 = edge[0].toInt()
                val vt2 = edge[1].toInt()

                val ll = adjList[vt1]!!
                ll.remove(vt2)
                adjList[vt1] = ll

                var ll1 = adjList[vt2]!!
                ll1.remove(vt1)
                adjList[vt2] = ll1

                if(dfnMap[vt1]!! > dfnMap[vt2]!!){
                    var ll = backeEdgeMap.getOrDefault(vt1, arrayListOf())
                    if(!ll.contains(vt2))
                        ll.add(vt2)
                    backeEdgeMap[vt1] = ll
                }else{
                    var ll = backeEdgeMap.getOrDefault(vt2, arrayListOf())
                    if(!ll.contains(vt1))
                        ll.add(vt1)
                    backeEdgeMap[vt2] = ll                }
            }
        }
        return backeEdgeMap
    }

}
package graph

import java.lang.IllegalStateException
import kotlin.collections.HashMap

/**
 * Find articulation/Critical edge in Connected component.
 * It helps to find single point of failure in network grid.
 * Trojan Algorithm
 */
class ArticulationPoint {

    private var dfn = 1
    private var dfnMap: HashMap<Int, Int> = HashMap()
    private var lowMap: HashMap<Int, Int> = HashMap()
    private var edgeSetAfterDfn = HashSet<String>()
    private var edgeSet = HashSet<String>()

    fun articulationPoint(adjList: HashMap<Int, List<Int>>, root: Int) {
        adjList.forEach {entrySet ->
            entrySet.value.forEach {
                val edge = "${entrySet.key} $it"
                if(!edgeSet.contains(edge))
                    edgeSet.add(edge)
            }
        }

        dfnMap[root] = 1
        addDfn(adjList, root)

        val bEMap = backEdgeSet(edgeSet,edgeSetAfterDfn)

        //Sort the map by value in ascending ways
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

        adjList.forEach{ entry ->
            if(entry.key == root && entry.value.size > 1){
                // root with two children will be not consider as articulation point
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

    private fun addDfn(adjList: HashMap<Int, List<Int>>, root: Int){
        adjList[root]?.forEach {
            if(!dfnMap.containsKey(it)) {
                dfnMap[it] = ++dfn
                val edge = "$root $it"
                if (!edgeSetAfterDfn.contains(edge))
                    edgeSetAfterDfn.add(edge)
                addDfn(adjList, it)
            }
        }
    }

    private fun backEdgeSet(edgeSet1: HashSet<String>, edgeSet2: HashSet<String>): HashMap<Int, ArrayList<Int>>{
        var backeEdgeMap = HashMap<Int, ArrayList<Int>>()
        edgeSet1.forEach {
            val edge = it.split(" ")
            if(edge.size != 2)
                throw IllegalStateException()
            if(!edgeSet2.contains(it)) {
                val vt1 = edge[0].toInt()
                val vt2 = edge[1].toInt()

                if(dfnMap[vt1]!! > dfnMap[vt2]!!){
                    var ll = backeEdgeMap.getOrDefault(vt1, arrayListOf())
                    ll.add(vt2)
                    backeEdgeMap[vt1] = ll
                }else{
                    var ll = backeEdgeMap.getOrDefault(vt2, arrayListOf())
                    ll.add(vt1)
                    backeEdgeMap[vt2] = ll                }
            }
        }
        return backeEdgeMap
    }

}
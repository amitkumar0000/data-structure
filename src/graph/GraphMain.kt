package graph

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class GraphMain {

    enum class METHODNAME {
        DisjointSet,
        ArticulationPoint
    }
    val methodName = METHODNAME.ArticulationPoint
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println("====== Graph =====")
            val gm = GraphMain()

            when(gm.methodName) {
                METHODNAME.DisjointSet ->
                    gm.disjointSet()
                METHODNAME.ArticulationPoint ->
                    gm.articulationPoint()
            }
        }
    }

    /**
     * Articulation Point
     */
    private fun articulationPoint() {
        val ap = ArticulationPoint()

        val adjList = HashMap<Int, List<Int>>()
        adjList[1] = listOf(2,4)
        adjList[2] = listOf(1,3)
        adjList[3] = listOf(2,4,5,6)
        adjList[4] = listOf(1,3)
        adjList[6] = listOf(3,5)
        adjList[5] = listOf(3,6)

        ap.articulationPoint(adjList = adjList, root = 1)
    }

    /**
     * Disjoint set
     */
    private fun disjointSet() {
        val adjList = HashMap<Int, ArrayList<Int>>()
        adjList[1] = arrayListOf(2,3)
        adjList[2] = arrayListOf(4)
        adjList[3] = arrayListOf()
        adjList[4] = arrayListOf(5,6)
        adjList[5] = arrayListOf(7)
        adjList[6] = arrayListOf()
        adjList[7] = arrayListOf()
        val djSet = DisjointSetMap()

        adjList.forEach {
            djSet.makeSet(it.key)
        }

        djSet.union(1, 3)
        djSet.union(1,2)
        djSet.union(4,5)
        djSet.union(5,7)
        djSet.union(2,4)
        djSet.union(4,6)

        print("parent: ${djSet.findSet(3).data}")

    }
}
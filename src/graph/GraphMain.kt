package graph

class GraphMain {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println("====== Graph =====")
            val gm = GraphMain()

            gm.disjointSet()
        }
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
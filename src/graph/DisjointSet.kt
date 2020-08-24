package graph

import kotlin.math.abs

data class Node(val data: Int, var parent: Node? = null, var rank: Int = -1)
abstract class DisjointSet{
    internal var set = HashMap<Int, Node>()
    abstract fun makeSet(data: Int)
    abstract fun findSet(data: Int): Node
    abstract fun union(d1: Int, d2: Int)
}

class DisjointSetMap : DisjointSet() {
    override fun makeSet(data: Int) {
        val node = Node(data = data)
        node.parent = node
        set[data] = node
    }

     override fun findSet(data: Int): Node {
        if(set[data]?.parent?.data!! == data)
            return set[data]?.parent!!
        return findSet(set[data]?.parent?.data!!)
    }

    override fun union(d1: Int, d2: Int) {
        val p1 = findSet(d1)
        val p2 = findSet(d2)

        if(abs(p1?.rank) > abs(p2?.rank)){
            p2?.parent = p1
            p1?.rank = p1?.rank!! - 1
        } else {
            p1?.parent = p2
            p2?.rank = p2?.rank!! - 1
        }
    }
}

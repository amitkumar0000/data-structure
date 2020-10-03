package tree

import java.util.LinkedList

class BinaryTree {
    private var root: Tree? = null

    fun addAll(data: Array<Int?>) {
        for (i in data.indices) {
            add(data[i])
        }
    }

    fun add(`val`: Int?) {

        val nval = `val` ?: Int.MAX_VALUE   // Any node with Int.MAX_VALUE means null node

        val node = Tree(nval)
        if (root == null) {
            if(nval != Int.MAX_VALUE)
                root = node
        } else {
            var ptr = searchNextNodeInlevelOrder(root!!)

            if (ptr?.left == null) {
                ptr?.left = node
            } else {
                ptr.right = node
            }
        }
    }

    private fun searchNextNodeInlevelOrder(ptr: Tree): Tree {
        val queue = LinkedList<Tree>()
        queue.add(ptr)

        while (queue.isNotEmpty()) {
            val node = queue.poll()

            if (node.left == null
                    || node.right == null) {
                return node
            }
            queue.add(node.left!!)
            queue.add(node.right!!)
        }
        throw IllegalStateException()
    }

    internal fun printBinaryTree(){
        val queue = LinkedList<Tree>()
        if(root != null)
            queue.add(root!!)
        while(queue.isNotEmpty()){
            val node = queue.poll()
            if(node.`val` != Int.MAX_VALUE){
                print("${node.`val`} ")
            }else {
                print("null ")
            }
            node.left?.let{
                queue.add(it)
            }
            node.right?.let{
                queue.add(it)
            }
        }
        println()
    }
}



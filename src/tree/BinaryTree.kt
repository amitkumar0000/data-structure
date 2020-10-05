package tree

import java.util.LinkedList
import java.util.Stack

/****
 * Inorder/PreOrder/PostOrder
 * Level order
 * Left View
 * Right View
 * Vertical View
 * Top View
 * Bottom View
 * Diagonal View
 * Spiral/zig-zag view
 */
class BinaryTree {
    var root: Tree? = null

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

}



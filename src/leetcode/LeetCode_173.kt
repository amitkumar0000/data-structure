package leetcode

import tree.Tree

class LeetCode_173(val root: Tree?) {
    var ptr: Tree? = null



    /** @return the next smallest number */
    fun next(): Int {
        if(ptr == null) {
            ptr = leftMost(root)
            return ptr!!.`val`
        }
        ptr?.let{
            ptr = inOrderSuccessor(root, it.`val`)
        }
        return ptr!!.`val`
    }

    /** @return whether we have a next smallest number */
    fun hasNext(): Boolean {
        val prev = ptr
        ptr?.let {
            ptr = inOrderSuccessor(root, it.`val`)
        }
        val res = ptr
        ptr = prev

        return res != null
    }

    fun inOrderSuccessor(root: Tree?, num: Int): Tree? {
        var ptr = root
        var store: Tree? = null
        while (ptr != null) {
            if(ptr.`val` == num){
                // Case 1. Node right is not null
                // then node right leftmost is null,
                // if node right left is null, then node right is answer
                if(ptr?.right != null){
                    return if(ptr.right?.left != null)
                        leftMost(ptr.right)
                    else
                        ptr.right
                }else{
                    // Case 2. Node right is null
                    //then node at which last left turn is taken is answer
                    return store
                }
            }else if(ptr.`val` > num) {
                store = ptr
                ptr = ptr.left
            }else {
                ptr = ptr.right
            }
        }
        return null
    }

    private fun leftMost(node: Tree?): Tree? {
        if (node?.left == null) {
            return node
        }
        return leftMost(node.left)
    }

}
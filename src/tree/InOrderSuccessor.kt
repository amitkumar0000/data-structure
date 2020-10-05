package tree

class InOrderSuccessor {
    internal fun inOrderSuccessor(root: Tree?, num: Int): Int {
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
                        ptr.right!!.`val`
                }else{
                    // Case 2. Node right is null
                    //then node at which last left turn is taken is answer
                    return store?.`val` ?: -1
                }
            }else if(ptr.`val` > num) {
                store = ptr
                ptr = ptr.left
            }else {
                ptr = ptr.right
            }
        }
        return -1
    }

    internal fun inorderSuccessorRecursion(root: Tree?, num: Int, store: Tree?): Int {
        var res = -1
        if(root == null)
            return res

        if(root.`val` == num) {
            if(root.right != null){
                if(root.right?.left == null) {
                    return root.right!!.`val`
                }else {
                    return leftMost(root.right)
                }
            }else {
                return store?.`val` ?: -1
            }
        }else if(root.`val` > num){
            res = inorderSuccessorRecursion(root.left, num, root)
        }else {
            res = inorderSuccessorRecursion(root.right, num, store)
        }

        return res
    }

    private fun leftMost(node: Tree?): Int {
        if (node?.left == null) {
            return node!!.`val`
        }
        return leftMost(node.left)
    }

}
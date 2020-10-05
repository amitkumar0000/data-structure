package tree

class InorderPrdeccessor {

    internal fun inOrderPredecessor(root: Tree?, num: Int): Int {
        if(root == null) return -1
        var ptr = root
        var store: Tree? = null
        while(ptr != null){
            if(ptr.`val` == num){
                // Case 1 if left node is present
                // then node left rightmost is answer
                // if node left righ is null, then node.left is answer
                return if(ptr.left != null) {
                    return if(ptr.left?.right == null)
                        ptr.left!!.`val`
                    else
                        rightMost(ptr.left)
                }else {
                    // Case 2 the node where it take last right
                    store?.`val` ?: -1
                }
            } else if(ptr.`val` > num) {
                ptr = ptr.left
            } else {
                store = ptr
                ptr = ptr.right
            }
        }
        return -1
    }

    private fun rightMost(node: Tree?): Int {
        if(node?.right == null)
            return node!!.`val`
        return rightMost(node.right)
    }
}
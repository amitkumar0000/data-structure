package tree

/***
 * Binary Search Tree
 * Insertion
 * Print all path from root to leaf
 * Inorder Successor
 * Inorder Predecessor
 */
class BinarySearchTree {
    var root: Tree? = null

    fun addAll(list: List<Int>) {
        list.forEach { add(it) }
    }

    fun add(num: Int) {
        var node = Tree(num)
        if (root == null) {
            root = node
        } else {
            var ptr = root
            while (ptr?.left != null || ptr?.right != null) {
                ptr = if (ptr.`val` > num && ptr.left != null) {
                    ptr.left
                } else if (ptr.`val` < num && ptr.right != null) {
                    ptr.right
                } else {
                    break
                }
            }

            if (ptr?.`val`!! > num) {
                ptr.left = node
            } else {
                ptr.right = node
            }

        }
    }

    internal fun inOrder(root: Tree?) {
        if (root == null)
            return
        inOrder(root.left)
        print("${root.`val`} ")
        inOrder(root.right)
    }

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

    private fun leftMost(node: Tree?): Int {
        if (node?.left == null) {
            return node!!.`val`
        }
        return leftMost(node.left)
    }

    internal fun rootToLeaf(root: Tree?, path: ArrayList<Int>) {
        if (root == null)
            return
        if (root.left == null && root.right == null) {
            path.forEach { print("$it ") };println()
        }

        root.left?.let {
            path.add(it.`val`)
            rootToLeaf(root.left, path)
            path.remove(it.`val`)
        }

        root.right?.let {
            path.add(it.`val`)
            rootToLeaf(root.right, path)
            path.remove(it.`val`)
        }
    }

}
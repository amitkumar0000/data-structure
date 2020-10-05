package tree

/***
 * Binary Search Tree
 * Insertion
 * Print all path from root to leaf
 * Inorder Successor
 * Inorder Predecessor
 * Lowest Common Ancestor
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
}
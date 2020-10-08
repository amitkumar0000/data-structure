package tree

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 */
class DFS {
    internal fun DFS(root: Tree?) {
        println("=== Inorder ===")
        inOrder(root)
        println("\n=== Preoder ===")
        preOrder(root).forEach {
            print("$it")
        }
        println("\n=== PostOrder ===")
        postOrder(root).forEach { print("$it ") }
    }

    internal fun inOrder(root: Tree?) {
        if(root == null)
            return
        inOrder(root.left)
        if(root.`val` != Int.MAX_VALUE)
            print("${root.`val`} ")
        inOrder(root.right)

    }

    internal fun preOrder(root: Tree?): List<Int> {
        val list = arrayListOf<Int>()
        if(root == null)
            return list
        if(root.`val` != Int.MAX_VALUE) {
            list.add(root.`val`)
        }
        preOrder(root.left).forEach {
            list.add(it)
        }
        preOrder(root.right).forEach {
            list.add(it)
        }
        return list
    }

    internal fun postOrder(root: Tree?): List<Int> {
        val list = arrayListOf<Int>()
        if(root == null)
            return list
        postOrder(root.left).forEach { list.add(it) }
        postOrder(root.right).forEach { list.add(it) }
        if(root.`val` != Int.MAX_VALUE) {
            list.add(root.`val`)
        }
        return list
    }
}
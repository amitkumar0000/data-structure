package tree

class DFS {
    internal fun DFS(root: Tree?) {
        println("=== Inorder ===")
        inOrder(root)
        println("\n=== Preoder ===")
        preOrder(root)
        println("\n=== PostOrder ===")
        postOrder(root)
    }

    internal fun inOrder(root: Tree?) {
        if(root == null)
            return
        inOrder(root.left)
        if(root.`val` != Int.MAX_VALUE)
            print("${root.`val`} ")
        inOrder(root.right)

    }

    internal fun preOrder(root: Tree?) {
        if(root == null)
            return
        if(root.`val` != Int.MAX_VALUE)
            print("${root.`val`} ")
        preOrder(root.left)
        preOrder(root.right)

    }

    internal fun postOrder(root: Tree?) {
        if(root == null)
            return
        postOrder(root.left)
        postOrder(root.right)
        if(root.`val` != Int.MAX_VALUE)
            print("${root.`val`} ")
    }
}
package tree

class LCA {
    // LCA
    //
    internal fun lca(root: Tree?, num1: Int, num2: Int): Int {
        if(root == null)
            return -1
        return if(root.`val` in  num1..num2 || root.`val` in num2..num1)
            root.`val`
        else if(root.`val` > num1 && root.`val` > num2)
            lca(root.left, num1, num2)
        else
            lca(root.right, num1, num2)

    }
}
package tree

class Height {
    fun height(root: Tree?): Int{
        if(root == null)
            return 0
        return 1 + Math.max(height(root?.left), height(root.right))
    }
}
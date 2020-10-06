package tree

class Diameter {
    fun diameter(root: Tree?): Int {
        if(root == null)
            return 0

        return Math.max(Math.max(diameter(root.left), diameter(root.right)), 1 + height(root.left) + height(root.right))
    }

    private fun height(node: Tree?): Int{
        if(node == null)
            return 0
        return 1 + Math.max(height(node.left), height(node.right))
    }
}
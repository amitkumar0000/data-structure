package tree

class RootToLeaf {
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
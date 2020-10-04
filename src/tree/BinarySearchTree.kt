package tree

class BinarySearchTree {
    var root: Tree? = null

    fun addAll(list: List<Int>) {
        list.forEach { add(it) }
    }

    fun add(num: Int) {
        var node = Tree(num)
        if(root == null){
            root = node
        } else {
            var ptr = root
            while(ptr?.left != null || ptr?.right != null) {
                ptr = if(ptr.`val` > num && ptr.left != null){
                    ptr.left
                } else if(ptr.`val` < num && ptr.right != null){
                    ptr.right
                } else {
                    break
                }
            }

            if(ptr?.`val`!! > num) {
                ptr.left = node
            }else {
                ptr.right = node
            }

        }
    }

    internal fun inOrder(root: Tree?) {
        if(root == null)
            return
        inOrder(root.left)
        print("${root.`val`} ")
        inOrder(root.right)
    }

    internal  fun rootToLeaf(root: Tree?, path: ArrayList<Int>) {
        if(root == null)
            return
        if(root.left == null && root.right == null) {
            path.forEach { print("$it ") };println()
        }

        root.left?.let{
            path.add(it.`val`)
        }
        rootToLeaf(root.left, path)
        root.left?.let{
            path.remove(it.`val`)
        }

        root.right?.let { path.add(it.`val`) }
        rootToLeaf(root.right, path)
        root.right?.let { path.remove(it.`val`) }
    }
}
package tree

import java.util.LinkedList

class BinaryTree {
    private var root: Tree? = null

    fun addAll(data: Array<Int?>) {
        for (i in data.indices) {
            add(data[i])
        }
    }

    fun add(`val`: Int?) {

        val nval = `val` ?: Int.MAX_VALUE   // Any node with Int.MAX_VALUE means null node

        val node = Tree(nval)
        if (root == null) {
            if(nval != Int.MAX_VALUE)
                root = node
        } else {
            var ptr = searchNextNodeInlevelOrder(root!!)

            if (ptr?.left == null) {
                ptr?.left = node
            } else {
                ptr.right = node
            }
        }
    }

    private fun searchNextNodeInlevelOrder(ptr: Tree): Tree {
        val queue = LinkedList<Tree>()
        queue.add(ptr)

        while (queue.isNotEmpty()) {
            val node = queue.poll()

            if (node.left == null
                    || node.right == null) {
                return node
            }
            queue.add(node.left!!)
            queue.add(node.right!!)
        }
        throw IllegalStateException()
    }

    internal fun BFS(){
        val queue = LinkedList<Tree>()
        if(root != null)
            queue.add(root!!)
        while(queue.isNotEmpty()){
            val node = queue.poll()
            if(node.`val` != Int.MAX_VALUE){
                print("${node.`val`} ")
            }else {
                print("null ")
            }
            node.left?.let{
                queue.add(it)
            }
            node.right?.let{
                queue.add(it)
            }
        }
        println()
    }

    internal fun printLevelOrderLineByLine() {
        val queue = LinkedList<Tree>()
        var cc = 0
        var fc = 0
        if(root != null){
            cc = 1
            queue.add(root!!)
        }

        while(queue.isNotEmpty()) {
            val node = queue.poll()
            if(node.`val` != Int.MAX_VALUE) {
                print("${node.`val`} ")
            } else {
                print("null ")
            }
            cc -= 1
            node.left?.let{
                queue.add(it)
                fc += 1
            }
            node.right?.let {
                queue.add(it)
                fc += 1
            }
            if(cc == 0){
                cc = fc
                fc = 0
                println()
            }
        }
    }

    internal fun DFS() {
        println("=== Inorder ===")
        inOrder(root)
        println("\n=== Preoder ===")
        preOrder(root)
        println("\n=== PostOrder ===")
        postOrder(root)
    }

    private fun inOrder(root: Tree?) {
        if(root == null)
            return
        inOrder(root.left)
        if(root.`val` != Int.MAX_VALUE)
            print("${root.`val`} ")
        inOrder(root.right)

    }

    private fun preOrder(root: Tree?) {
        if(root == null)
            return
        if(root.`val` != Int.MAX_VALUE)
            print("${root.`val`} ")
        preOrder(root.left)
        preOrder(root.right)

    }

    private fun postOrder(root: Tree?) {
        if(root == null)
            return
        postOrder(root.left)
        postOrder(root.right)
        if(root.`val` != Int.MAX_VALUE)
            print("${root.`val`} ")
    }

    fun leftView(): List<Int> {
        if(root == null) return listOf()
        var cc = 1
        var fc = 0
        val queue = LinkedList<Tree>()
        var list = arrayListOf<Int>()
        queue.add(root!!)
        var isleft = true
        while(queue.isNotEmpty()) {
            val node = queue.poll()
            if(isleft){
                isleft = false
                list.add(node.`val`)
            }
            cc--
            node.left?.let{
                if(it.`val` != Int.MAX_VALUE) {
                    queue.add(it)
                    fc++
                }
            }
            node.right?.let {
                if(it.`val` != Int.MAX_VALUE) {
                    queue.add(it)
                    fc++
                }
            }
            if(cc == 0) {
                cc = fc
                fc = 0
                isleft = true
            }
        }
        return list
    }

    fun rightView(): List<Int> {
        var list = arrayListOf<Int>()

        if(root == null) return list
        var cc = 1
        var fc = 0
        val queue = LinkedList<Tree>()
        queue.add(root!!)
        while(queue.isNotEmpty()) {
            val node = queue.poll()
            cc--
            node.left?.let{
                if(it.`val` != Int.MAX_VALUE) {
                    queue.add(it)
                    fc++
                }
            }
            node.right?.let {
                if(it.`val` != Int.MAX_VALUE) {
                    queue.add(it)
                    fc++
                }
            }
            if(cc == 0) {
                cc = fc
                fc = 0
                list.add(node.`val`)
            }
        }
        return list
    }

    fun verticalView() : List<List<Int>>{
        val rlist = arrayListOf<ArrayList<Int>>()
        if(root == null) return rlist

        var hd = 0
        var vmap = HashMap<Int, ArrayList<Int>>()
        var hdMap = HashMap<Int, Int>()

        var queue = LinkedList<Tree>()
        queue.add(root!!)
        hdMap[root!!.`val`] = hd
        vmap[hd] = arrayListOf(root!!.`val`)

        while(queue.isNotEmpty()){
            val node = queue.poll()
            hd = hdMap[node.`val`]!!

            node?.left?.let {
                hdMap[it.`val`] = hd - 1
                val list = vmap.getOrDefault(hd-1, arrayListOf())
                list.add(it.`val`)
                vmap[hd-1] = list
                queue.add(it)
            }

            node?.right?.let {
                hdMap[it.`val`] = hd + 1
                val list = vmap.getOrDefault(hd+1, arrayListOf())
                list.add(it.`val`)
                vmap[hd+1] = list
                queue.add(it)
            }
        }

        vmap.keys.sorted().forEach {
            var list = arrayListOf<Int>()
            vmap[it]!!.forEach {
              list.add(it)
            }
            rlist.add(list)
        }
        return rlist
    }

    fun topView() {}

    fun bottomView() {}

    fun spiralView() {}

    fun diagonalView() {}
}



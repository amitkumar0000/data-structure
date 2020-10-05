package tree

import java.util.*

class LeftView {
    fun leftView(root: Tree?): List<Int> {
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
}
package tree

import java.util.*

class RightView {
    fun rightView(root: Tree?): List<Int> {
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

}
package tree

import java.util.*

class BFS {
    internal fun BFS(root: Tree?){
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

    internal fun printLevelOrderLineByLine(root: Tree?) {
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
}
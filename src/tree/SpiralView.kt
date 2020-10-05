package tree

import java.util.*

class SpiralView {
    fun spiralView(root: Tree?): List<Int> {
        val rlist = arrayListOf<Int>()
        if(root == null) return rlist

        var stack1 = Stack<Tree>()
        var stack2 = Stack<Tree>()

        stack1.add(root!!)

        while(stack1.isNotEmpty() || stack2.isNotEmpty()) {

            while(stack1.isNotEmpty()){
                val node = stack1.pop()
                rlist.add(node.`val`)
                node?.right?.let{
                    stack2.add(it)
                }
                node?.left?.let{
                    stack2.add(it)
                }
            }

            while(stack2.isNotEmpty()){
                val node = stack2.pop()
                rlist.add(node.`val`)
                node?.left?.let{
                    stack1.add(it)
                }
                node?.right?.let{
                    stack1.add(it)
                }
            }
        }
        return rlist
    }

}
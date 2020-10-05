package tree

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class VerticalView {
    fun verticalView(root: Tree?) : List<List<Int>>{
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

}
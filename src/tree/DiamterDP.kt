package tree

/**
 *  Dynamic programming Diamter of tree
 *  Top-Down approach
 *
 */
class DiameterDP {
    fun diameter(root: Tree?, hmap: HashMap<Int, Int>, dmap: HashMap<Int,Int>): Int {
        if(root == null)
            return 0
        if(dmap.containsKey(root.`val`))  // Diameter is calculated multiple times, Memorize it
            return dmap[root.`val`]!!

        root.left?.let {
            dmap[it.`val`] = diameter(root.left, hmap, dmap)
        }

        root.right?.let {
            dmap[it.`val`] = diameter(root.right, hmap, dmap)
        }

        return Math.max(Math.max(diameter(root.left, hmap, dmap), diameter(root.right, hmap, dmap)), 1 + heightRoot(root.left, hmap) + heightRoot(root.right, hmap))
    }

    private fun height(node: Tree?): Int{
        if(node == null)
            return 0
        return 1 + Math.max(height(node.left), height(node.right))
    }

    private fun heightRoot(root: Tree?, hmap: HashMap<Int, Int>): Int{
        if(root == null)
            return 0
        if(hmap.containsKey(root.`val`)) {  // Height is calculated multiple times, Memorize it
            return hmap[root.`val`]!!
        }

        hmap[root.`val`] = 1 + Math.max(heightRoot(root.left,hmap), heightRoot(root.right, hmap))

        return hmap[root.`val`]!!

    }
}
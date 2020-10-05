package tree

class RootToPathSum {
    fun printRootToPathSum(root: Tree?, sum: Int, path: ArrayList<Int>){
        if(root == null)
            return
        if(sum == 0) {
            path.forEach {print("$it ")};println()
            return
        } else if(sum < 0){
            return
        }

        root?.left?.let{
            path.add(it.`val`)
            printRootToPathSum(it, sum - it.`val`, path)
            path.remove(it.`val`)
        }

        root?.right?.let{
            path.add(it.`val`)
            printRootToPathSum(it, sum - it.`val`, path)
            path.remove(it.`val`)
        }

    }
}
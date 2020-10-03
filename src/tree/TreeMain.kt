package tree

class TreeMain {

    enum class TreeQuestion {
        insertAll,
        levelOrder,
        BFS,
        DFS
    }

    companion object{
        @JvmStatic
         fun main(args: Array<String>){
            val main = TreeMain()
            val question = TreeQuestion.DFS

            when(question) {
                TreeQuestion.insertAll -> {
                    main.addAll()
                }
                TreeQuestion.levelOrder -> {
                    main.BFSwithNewLine()
                }
                TreeQuestion.BFS -> {
                    main.BFS()
                }
                TreeQuestion.DFS -> {
                    main.DFS()
                }
            }
        }
    }

    private fun addAll(): BinaryTree {
        val bt = BinaryTree()
        bt.addAll(arrayOf(1,2,3,4,null,5,null,6))
        return bt
    }

    private fun BFS() {
        val bt = addAll()
        bt.BFS()
    }

    private fun BFSwithNewLine() {
        val bt = addAll()
        bt.printLevelOrderLineByLine()
    }

    private fun DFS() {
        val bt = addAll()
        bt.DFS()
    }

}
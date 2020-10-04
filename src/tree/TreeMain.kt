package tree

class TreeMain {

    enum class TreeQuestion {
        insertAll,
        levelOrder,
        BFS,
        DFS,
        LeftView,
        RightView,
        TopView,
        BottomView,
        DiagonalView,
        VerticalView,
        SpiralView
    }

    companion object{
        @JvmStatic
         fun main(args: Array<String>){
            val main = TreeMain()
            val question = TreeQuestion.SpiralView

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
                TreeQuestion.LeftView -> {
                    main.leftView()
                }
                TreeQuestion.RightView -> {
                    main.rightView()
                }
                TreeQuestion.TopView -> {
                    main.topView()
                }
                TreeQuestion.BottomView -> {
                    main.bottomView()
                }
                TreeQuestion.SpiralView -> {
                    main.spiralView()
                }
                TreeQuestion.VerticalView -> {
                    main.verticalView()
                }
                TreeQuestion.DiagonalView-> {
                    main.diagonalView()
                }
            }
        }
    }

    private fun addAll(): BinaryTree {
        val bt = BinaryTree()
        bt.addAll(arrayOf(1,2,3,4,null,5,6,null,null,null,null, 7,null,null,null,null,null,null,null,null,null,null,null,9,8))
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

    private fun leftView() {
        val bt = addAll()
        print("left view:- ")
        bt.leftView().forEach { print("$it ") }
    }

    private fun rightView() {
        val bt = addAll()
        print("right view:- ")
        bt.rightView().forEach { print("$it ") }
    }

    private fun topView() {
        val bt = BinaryTree()
        bt.addAll(arrayOf(1,2,3,4,5,6,7))
        println("--- Top view ----")
        bt.verticalView().forEach {
            if(it.isNotEmpty())
                 print("${it[0]} ")
        };println()
    }

    private fun bottomView() {
        val bt = BinaryTree()
        bt.addAll(arrayOf(1,2,3,4,5,6,7))
        println("--- Top view ----")
        bt.verticalView().forEach {
            if(it.isNotEmpty())
                print("${it[it.size - 1]} ")
        };println()
    }

    private fun spiralView() {
        val bt = BinaryTree()
        bt.addAll(arrayOf(1,2,3,4,5,6,7,8,9,10,11))
        println("--- Spirak view ----")
        bt.spiralView().forEach {
            print("$it ")
        };println()
    }

    private fun diagonalView() {
        val bt = BinaryTree()
        bt.addAll(arrayOf(1,2,3,4,5,6,7))
        println("--- Top view ----")
        bt.diagonalView().forEach {
            rows -> rows.forEach { print("$it ") };println()
        };
    }

    private fun verticalView() {
        val bt = BinaryTree()
        bt.addAll(arrayOf(1,2,3,4,5,6,7))
        println("--- Vertical view ----")
        bt.verticalView().forEach {
            rows -> rows.forEach { print("$it ") };println()
        }
    }

}
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
            val question = TreeQuestion.RightView

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
        bt.leftView()
    }

    private fun rightView() {
        val bt = addAll()
        print("right view:- ")
        bt.rightView()
    }

    private fun topView() {
        val bt = addAll()
        bt.topView()
    }

    private fun bottomView() {
        val bt = addAll()
        bt.bottomView()
    }

    private fun spiralView() {
        val bt = addAll()
        bt.spiralView()
    }

    private fun diagonalView() {
        val bt = addAll()
        bt.diagonalView()
    }

    private fun verticalView() {
        val bt = addAll()
        bt.verticalView()
    }

}
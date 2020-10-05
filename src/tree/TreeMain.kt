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
        SpiralView,
        BinarySearchTreeAdd,
        InorderSuccessor,
        InorderPredecessor,
        PrintRootToLeaf,
        LCA,
    }

    companion object{
        @JvmStatic
         fun main(args: Array<String>){
            val main = TreeMain()

            when(TreeQuestion.LCA) {
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
                TreeQuestion.BinarySearchTreeAdd -> {
                    main.bstAdd()
                }
                TreeQuestion.InorderSuccessor -> {
                    main.inorderSuccessor()
                }
                TreeQuestion.InorderPredecessor -> {
                    main.inorderPredecessor()
                }
                TreeQuestion.PrintRootToLeaf -> {
                    main.printRootToLeaf()
                }
                TreeQuestion.LCA -> {
                    main.lca()
                }
            }
        }
    }

    private fun lca() {
        val bst = BinarySearchTree()
        bst.addAll(listOf(11,15,12,18,7,9,10,6,8,5,4))

        println("LCA(9,7)   ${bst.lca(bst.root, 9, 7)}")
        println("LCA(6,7)   ${bst.lca(bst.root, 6, 7)}")
        println("LCA(6,9)   ${bst.lca(bst.root, 6, 9)}")
        println("LCA(4,18)   ${bst.lca(bst.root, 4, 18)}")
    }

    private fun printRootToLeaf() {
        val bst = BinarySearchTree()
        bst.addAll(listOf(100,80,70,90,85,95,94,84,86,88,96,110,105,112,115))
        println("Printing All root to leaf node path:- ")
        if(bst.root != null)
            bst.rootToLeaf(bst.root, arrayListOf(bst.root!!.`val`))
    }

    private fun inorderSuccessor() {
        val bst = BinarySearchTree()
        bst.addAll(listOf(11,15,12,18,7,9,10,6,8,5,4))
        bst.inOrder(root = bst.root)
        println("\nInorder Successor :- ${bst.inorderSuccessorRecursion(bst.root, 10, null)}")
        println("Inorder Successor :- ${bst.inorderSuccessorRecursion(bst.root, 4, null)}")
        println("Inorder Successor :- ${bst.inorderSuccessorRecursion(bst.root, 18, null)}")
        println("Inorder Successor :- ${bst.inorderSuccessorRecursion(bst.root, 11,null)}")
    }

    private fun inorderPredecessor() {
        val bst = BinarySearchTree()
        bst.addAll(listOf(11,15,12,18,7,9,10,6,8,5,4))
        bst.inOrder(root = bst.root)
        println("\nInorder Predecessor :- ${bst.inOrderPredecessor(bst.root, 10)}")
        println("Inorder Predecessor :- ${bst.inOrderPredecessor(bst.root, 4)}")
        println("Inorder Predecessor :- ${bst.inOrderPredecessor(bst.root, 18)}")
        println("Inorder Predecessor :- ${bst.inOrderPredecessor(bst.root, 11)}")
    }

    private fun bstAdd() {
        val bst = BinarySearchTree()
        bst.addAll(listOf(10,4,12,3,13,2))
        bst.inOrder(bst.root)
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

    private fun verticalView() {
        val bt = BinaryTree()
        bt.addAll(arrayOf(1,2,3,4,5,6,7))
        println("--- Vertical view ----")
        bt.verticalView().forEach {
            rows -> rows.forEach { print("$it ") };println()
        }
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

    private fun diagonalView() {
        val bt = BinaryTree()
        bt.addAll(arrayOf(1,2,3,4,5,6,7))
        println("--- Top view ----")
        bt.diagonalView().forEach {
            rows -> rows.forEach { print("$it ") };println()
        };
    }

    private fun spiralView() {
        val bt = BinaryTree()
        bt.addAll(arrayOf(1,2,3,4,5,6,7,8,9,10,11))
        println("--- Spirak view ----")
        bt.spiralView().forEach {
            print("$it ")
        };println()
    }

}
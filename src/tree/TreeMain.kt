package tree

class TreeMain {

    enum class TreeQuestion {
        InsertAll,
        LevelOrder,
        Height,
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
        RootToSumPath,
        Diameter,
        ConstructInorderPreorder,
        ConstructInorderPostorder,
    }

    companion object{
        @JvmStatic
         fun main(args: Array<String>){
            val main = TreeMain()

            when(TreeQuestion.ConstructInorderPreorder) {
                TreeQuestion.InsertAll -> {
                    main.addAll()
                }
                TreeQuestion.Height -> {
                    main.height()
                }
                TreeQuestion.LevelOrder -> {
                    main.BFSwithNewLine()
                }
                TreeQuestion.BFS -> {
                    main.bfs()
                }
                TreeQuestion.DFS -> {
                    main.dfs()
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
                TreeQuestion.RootToSumPath -> {
                    main.rootToSumPath()
                }
                TreeQuestion.Diameter -> {
                    main.diameter()
                }
                TreeQuestion.ConstructInorderPreorder -> {
                    main.constructInorderPreorder()
                }
            }
        }
    }

    private fun constructInorderPreorder() {
        val bst = BinarySearchTree()
        bst.addAll(listOf(80,70,95,60,75,90,100,50,65,94,97))
        bst.inOrder(bst.root);println()

        val construct = ConstructTree()
        val root = construct.constructInorderPreorder(intArrayOf(50,60,65,70,75,80,90,94,95,97,100), intArrayOf(80,70,60,50,65,75,95,90,94,100,97))

        bst.inOrder(root)

    }

    private fun height() {
        val bst = BinarySearchTree()
        bst.addAll(listOf(80,70,75,60,50,65,66,95,90,100,94,97))

        val height = Height()
        println("Height of tree: ${height.height(bst.root)}")
    }

    private fun diameter() {
        val bst = BinarySearchTree()
        bst.addAll(listOf(90,100,80,70,60,75,79,85,83,84,86,95,110,105,115,108,109))

        val diameter = DiameterDP()
        println("Diameter of tree : ${diameter.diameter(bst.root, hashMapOf(), hashMapOf())}")
    }

    private fun rootToSumPath() {
        val bst = BinarySearchTree()
        bst.addAll(listOf(10,12,5,7,4,3))
        val rps = RootToPathSum()
        if(bst.root != null)
            rps.printRootToPathSum(bst.root,  22 - bst.root!!.`val`, arrayListOf(bst.root!!.`val`))
    }

    private fun lca() {
        val bst = BinarySearchTree()
        bst.addAll(listOf(11,15,12,18,7,9,10,6,8,5,4))
        val lca = LCA()
        println("LCA(9,7)   ${lca.lca(bst.root, 9, 7)}")
        println("LCA(6,7)   ${lca.lca(bst.root, 6, 7)}")
        println("LCA(6,9)   ${lca.lca(bst.root, 6, 9)}")
        println("LCA(4,18)   ${lca.lca(bst.root, 4, 18)}")
    }

    private fun printRootToLeaf() {
        val bst = BinarySearchTree()
        bst.addAll(listOf(100,80,70,90,85,95,94,84,86,88,96,110,105,112,115))
        println("Printing All root to leaf node path:- ")
        val rootToLeaf = RootToLeaf()
        if(bst.root != null)
            rootToLeaf.rootToLeaf(bst.root, arrayListOf(bst.root!!.`val`))
    }

    private fun inorderSuccessor() {
        val bst = BinarySearchTree()
        bst.addAll(listOf(11,15,12,18,7,9,10,6,8,5,4))
        bst.inOrder(root = bst.root)

        val inds = InOrderSuccessor()
        println("\nInorder Successor :- ${inds.inorderSuccessorRecursion(bst.root, 10, null)}")
        println("Inorder Successor :- ${inds.inorderSuccessorRecursion(bst.root, 4, null)}")
        println("Inorder Successor :- ${inds.inorderSuccessorRecursion(bst.root, 18, null)}")
        println("Inorder Successor :- ${inds.inorderSuccessorRecursion(bst.root, 11,null)}")
    }

    private fun inorderPredecessor() {
        val bst = BinarySearchTree()
        bst.addAll(listOf(11,15,12,18,7,9,10,6,8,5,4))
        bst.inOrder(root = bst.root)
        val indp = InorderPrdeccessor()
        println("\nInorder Predecessor :- ${indp.inOrderPredecessor(bst.root, 10)}")
        println("Inorder Predecessor :- ${indp.inOrderPredecessor(bst.root, 4)}")
        println("Inorder Predecessor :- ${indp.inOrderPredecessor(bst.root, 18)}")
        println("Inorder Predecessor :- ${indp.inOrderPredecessor(bst.root, 11)}")
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

    private fun bfs() {
        val bt = addAll()
        val bfs = BFS()
        bfs.BFS(bt.root)
    }

    private fun BFSwithNewLine() {
        val bt = addAll()
        val bfs = BFS()
        bfs.printLevelOrderLineByLine(bt.root)
    }

    private fun dfs() {
        val bt = addAll()
        val bfs = DFS()

        bfs.DFS(bt.root)
    }

    private fun leftView() {
        val bt = addAll()
        print("left view:- ")

        val lv = LeftView()
        lv.leftView(bt.root).forEach { print("$it ") }
    }

    private fun rightView() {
        val bt = addAll()
        print("right view:- ")

        val rv = RightView()
        rv.rightView(bt.root).forEach { print("$it ") }
    }

    private fun verticalView() {
        val bt = BinaryTree()
        bt.addAll(arrayOf(1,2,3,4,5,6,7))
        println("--- Vertical view ----")
        val vv = VerticalView()
        vv.verticalView(bt.root).forEach {
            rows -> rows.forEach { print("$it ") };println()
        }
    }

    private fun topView() {
        val bt = BinaryTree()
        bt.addAll(arrayOf(1,2,3,4,5,6,7))
        println("--- Top view ----")
        val vv = VerticalView()

        vv.verticalView(bt.root).forEach {
            if(it.isNotEmpty())
                 print("${it[0]} ")
        };println()
    }

    private fun bottomView() {
        val bt = BinaryTree()
        bt.addAll(arrayOf(1,2,3,4,5,6,7))
        println("--- Top view ----")
        val vv = VerticalView()

        vv.verticalView(bt.root).forEach {
            if(it.isNotEmpty())
                print("${it[it.size - 1]} ")
        };println()
    }

    private fun diagonalView() {
        val bt = BinaryTree()
        bt.addAll(arrayOf(1,2,3,4,5,6,7))
        println("--- Top view ----")
        val vv = DiagonalView()

        vv.diagonalView(bt.root).forEach {
            rows -> rows.forEach { print("$it ") };println()
        };
    }

    private fun spiralView() {
        val bt = BinaryTree()
        bt.addAll(arrayOf(1,2,3,4,5,6,7,8,9,10,11))
        println("--- Spirak view ----")
        val vv = SpiralView()

        vv.spiralView(bt.root).forEach {
            print("$it ")
        };println()
    }

}
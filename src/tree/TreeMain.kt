package tree

class TreeMain {

    enum class TreeQuestion {
        insertAll
    }

    companion object{
        @JvmStatic
         fun main(args: Array<String>){
            val main = TreeMain()
            val question = TreeQuestion.insertAll

            when(question) {
                TreeQuestion.insertAll -> {
                    main.addAll()
                }
            }
        }
    }

    private fun addAll() {
        val bt = BinaryTree()
        bt.addAll(arrayOf(1,2,3,4,null,5,6))

        bt.printBinaryTree()
    }

}
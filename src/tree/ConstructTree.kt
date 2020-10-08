package tree

import java.util.*

/****
 * Tree can't be constructed if inorder is not given
 */
class ConstructTree {

    fun buildTree( preorder: IntArray = intArrayOf(), inorder: IntArray = intArrayOf()): Tree?{
        if(inorder.isEmpty() || preorder.isEmpty())
            return null

        val root: Tree? = Tree(preorder[0])
        var rloc = search(inorder, preorder[0])  // Inorder is sorted only in BST
        if(rloc == -1)
            return root

        if(rloc >= 1)
             root?.left = buildTree(preorder.copyOfRange(1, rloc+1), inorder.copyOfRange(0, rloc))
        if(rloc+1 <= inorder.size -1 )
             root?.right = buildTree(preorder.copyOfRange(rloc+1, preorder.size), inorder.copyOfRange(rloc+1, inorder.size))
        return root
    }

    fun constructInorderPostorder(inorder: IntArray, postorder: IntArray): Tree?{
        if(inorder.isEmpty() || postorder.isEmpty())
            return null

        val root: Tree? = Tree(postorder[postorder.size - 1])
        var rloc = search(inorder, postorder[postorder.size - 1])
        if(rloc == -1)
            return root

        if(rloc >= 0)
            root?.left = constructInorderPostorder(inorder.copyOfRange(0, rloc), postorder.copyOfRange(0, rloc))
        if(rloc+1 <= inorder.size -1 && rloc <= postorder.size - 1)
            root?.right = constructInorderPostorder(inorder.copyOfRange(rloc+1, inorder.size), postorder.copyOfRange(rloc, postorder.size - 1))
        return root
    }

    fun search(array: IntArray, key: Int): Int {
        for(i in array.indices)
            if(array[i] == key)
                return i
        return -1
    }

}

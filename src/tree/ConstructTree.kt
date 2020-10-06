package tree

import java.util.*

/****
 * Tree can't be constructed if inorder is not given
 */
class ConstructTree {

    fun constructInorderPreorder(inorder: IntArray, preorder: IntArray): Tree?{
        if(inorder.isEmpty() || preorder.isEmpty())
            return null

        val root: Tree? = Tree(preorder[0])
        var rloc = Arrays.binarySearch(inorder, preorder[0])
        if(rloc == -1)
            return root

        if(rloc >= 1)
             root?.left = constructInorderPreorder(inorder.copyOfRange(0, rloc), preorder.copyOfRange(1, rloc+1))
        if(rloc+1 <= inorder.size -1 )
             root?.right = constructInorderPreorder(inorder.copyOfRange(rloc+1, inorder.size), preorder.copyOfRange(rloc+1, preorder.size))
        return root
    }

    fun constructInorderPostorder(inorder: IntArray, postorder: IntArray): Tree?{
        if(inorder.isEmpty() || postorder.isEmpty())
            return null

        val root: Tree? = Tree(postorder[postorder.size - 1])
        var rloc = Arrays.binarySearch(inorder, postorder[postorder.size - 1])
        if(rloc == -1)
            return root

        if(rloc >= 0)
            root?.left = constructInorderPostorder(inorder.copyOfRange(0, rloc), postorder.copyOfRange(0, rloc))
        if(rloc+1 <= inorder.size -1 && rloc <= postorder.size - 1)
            root?.right = constructInorderPostorder(inorder.copyOfRange(rloc+1, inorder.size), postorder.copyOfRange(rloc, postorder.size - 1))
        return root
    }

}
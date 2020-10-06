package tree

import java.util.*

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

}
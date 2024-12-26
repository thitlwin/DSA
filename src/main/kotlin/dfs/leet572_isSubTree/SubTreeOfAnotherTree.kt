package dfs.leet572_isSubTree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
class SubTreeOfAnotherTree {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if(root == null && subRoot == null) return true
        if(root == null || subRoot == null) return false
        val isSameTree = isSame(root, subRoot)
        val isInLeft = isSubtree(root.left, subRoot)
        val isInRight = isSubtree(root.right, subRoot)
        return isSameTree || isInLeft || isInRight
    }

    private fun isSame(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if(root == null && subRoot == null) return true
        if(root == null || subRoot == null) return false
        return (root.`val` == subRoot.`val`) && isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right)
    }
}
package leetcode_problem_226_DFS_InvertBinaryTree

data class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
class InvertBinaryTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        if(root == null) return null
        val temp = root.left
        root.left = root.right
        root.right = temp

        invertTree(root.left)
        invertTree(root.right)
        return root
    }

}
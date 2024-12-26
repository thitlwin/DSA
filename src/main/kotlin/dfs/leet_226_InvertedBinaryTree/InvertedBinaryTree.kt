package dfs.leet_226_InvertedBinaryTree

class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class InvertedBinaryTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        root ?: return null
        val left = invertTree(root.left)
        val right = invertTree(root.right)
        root.left = right
        root.right = left
        return root
    }
}
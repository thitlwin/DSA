package leetcode_problem_235_BST_LCA

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class LCA {
    fun lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode? {
        return if (p.`val` < root.`val` && q.`val` < root.`val`) {
            root.left?.let { lowestCommonAncestor(it, p, q) }
        } else if (p.`val` > root.`val` && q.`val` > root.`val`) {
            root.right?.let { lowestCommonAncestor(it, p, q) }
        } else
            root
    }
}
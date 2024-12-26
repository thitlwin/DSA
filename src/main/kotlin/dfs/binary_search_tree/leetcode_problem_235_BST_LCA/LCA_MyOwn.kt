package dfs.binary_search_tree.leetcode_problem_235_BST_LCA

class LCA_MyOwn {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        root ?: return null
        p ?:return null
        q ?: return null
        if(p.`val` < root.`val` && q.`val` < root.`val`) {
            return lowestCommonAncestor(root.left, p, q)
        } else if(p.`val` > root.`val` && q.`val` > root.`val`) {
            return lowestCommonAncestor(root.right, p, q)
        }
        return root
    }
}
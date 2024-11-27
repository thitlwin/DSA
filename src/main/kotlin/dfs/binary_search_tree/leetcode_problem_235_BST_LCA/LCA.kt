package dfs.binary_search_tree.leetcode_problem_235_BST_LCA

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class LCA {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        root ?: return null
        p ?: return null
        q ?: return null
        return if (p.`val` < root.`val` && q.`val` < root.`val`) {
            lowestCommonAncestor(root.left, p, q)
        } else if (p.`val` > root.`val` && q.`val` > root.`val`) {
            lowestCommonAncestor(root.right, p, q)
        } else
            root
    }
}

fun main() {
    val obj = LCA()
    val root = TreeNode(6)
        .apply {
            left = TreeNode(2).apply {
                left = TreeNode(0)
                right = TreeNode(4).apply {
                    left = TreeNode(3)
                    right = TreeNode(5)
                }
            }
            right = TreeNode(8).apply {
                left = TreeNode(7)
                right = TreeNode(9)
            }
        }
    val res = obj.lowestCommonAncestor(root,TreeNode(7), TreeNode(9))
    println(res?.`val`)
}
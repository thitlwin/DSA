package leetcode_problem_100

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if(p==null && q==null) return true
        if(p?.`val` != q?.`val`) return false else true

        return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)


    }
}
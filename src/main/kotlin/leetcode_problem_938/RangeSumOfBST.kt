package leetcode_problem_938

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class RangeSumOfBST {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        var result = 0
        if (root == null) return 0
        if (root.`val` in low..high) {
            result += root.`val`
        }
        result += rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high)
        return result
    }
}

fun main() {
    val _10 = TreeNode(10)
    val _5 = TreeNode(5)
    val _15 = TreeNode(15)
    val _3 = TreeNode(3)
    val _7 = TreeNode(7)
    val _18 = TreeNode(18)
    _10.left = _5
    _10.right = _15
    _5.left = _3
    _5.right = _7
    _15.right = _18

    val obj = RangeSumOfBST()
    println(obj.rangeSumBST(_10, 5, 18))
}
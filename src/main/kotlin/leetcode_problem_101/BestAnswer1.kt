package leetcode_problem_101

class BestAnswer1 {
    fun isSymmetric(root: TreeNode?): Boolean {
        return isSame(root?.left, root?.right)
    }

    private fun isSame(left: TreeNode?, right: TreeNode?): Boolean {
        return (left == null && right == null) ||
                (left?.`val` == right?.`val` && isSame(left?.left, right?.right) && isSame(left?.right, right?.left))
    }
}
fun main() {
    val obj = BestAnswer1()
    val _1 = TreeNode(1)
    val _2 = TreeNode(2)
    val _2_1 = TreeNode(2)
    val _2_2 = TreeNode(2)
    val _3 = TreeNode(3)
    val _4 = TreeNode(4)
    val _5 = TreeNode(5)
    val _6 = TreeNode(6)
    val _7 = TreeNode(7)
    val _8 = TreeNode(8)
    val _9 = TreeNode(9)

    _1.apply {
        left = _2_1
        right = _2_2
    }

    _2_1.apply {
        right = _3
    }

    _2_2.apply {
        right = _3
    }

    println(_1)
    val res = obj.isSymmetric(_1)
    println(res)
}
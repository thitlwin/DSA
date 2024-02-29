package leetcode_problem_2331

class BestAnswer1 {
    fun evaluateTree(root: TreeNode?): Boolean = when (root?.`val`) {
        1 -> true
        2 -> evaluateTree(root.left) || evaluateTree(root.right)
        3 -> evaluateTree(root.left) && evaluateTree(root.right)
        else -> false
    }
}

fun main() {
    val _1 = TreeNode(1)
    val _2 = TreeNode(2)
    val _3 = TreeNode(3)
    val _0 = TreeNode(0)
    val _1_1 = TreeNode(1)

    _2.apply {
        left = _1
        right = _3
    }

    _3.apply {
        left = _0
        right = _1_1
    }

    val obj = BestAnswer1()
    println(obj.evaluateTree(_0))
}
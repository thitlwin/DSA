package leetcode_problem_2331

class BestAnswer2 {
    fun evaluateTree(root: TreeNode?): Boolean {
        if (root == null) return false
        if (root.left == null) return root.`val` == 1
        return if (root.`val` == 2)
            evaluateTree(root.left) || evaluateTree(root.right)
        else
            evaluateTree(root.left) && evaluateTree(root.right)
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

    val obj = BestAnswer2()
    println(obj.evaluateTree(_2))
}
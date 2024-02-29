package leetcode_problem_2331

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class EvaluateBinaryTree {
    fun evaluateTree(root: TreeNode?): Boolean {
        return getValue(root)
    }

    fun getValue(root: TreeNode?): Boolean {
        if (root?.left == null) {
            return when (root?.`val`) {
                0 -> false
                1 -> true
                else -> false
            }
        }

        return when (root.`val`) {
            2 -> getValue(root.left) || getValue(root.right)
            3 -> getValue(root.left) && getValue(root.right)
            else -> false
        }
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

    val obj = EvaluateBinaryTree()
    println(obj.evaluateTree(_2))
}
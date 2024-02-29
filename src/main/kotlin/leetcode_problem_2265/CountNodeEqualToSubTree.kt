package leetcode_problem_2265

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class CountNodeEqualToSubTree {
    var result = 0
    var sum = 0
    var count = 0
    fun averageOfSubtree(root: TreeNode?): Int {
        root ?: return 0
        count = 0
        sum = 0

        if (avg(root) == root.`val`)
            result += 1

        count = 0
        sum = 0
        averageOfSubtree(root.left)
        count = 0
        sum = 0
        averageOfSubtree(root.right)
        return result
    }

    fun avg(root: TreeNode?): Int {
        root ?: return 0
        if (root.left == null && root.right == null) return root.`val`

        count++
        sum += root.`val`

        avg(root.left)
        avg(root.right)
        return Math.floor(sum.toDouble() / count.toDouble()).toInt()
    }
}

fun main() {
//    val _4 = TreeNode(4)
//    val _8 = TreeNode(8)
//    val _5 = TreeNode(5)
//    val _0 = TreeNode(0)
//    val _1 = TreeNode(1)
//    val _6 = TreeNode(6)
//
//    _4.apply {
//        left = _8
//        right = _5
//    }
//
//    _8.apply {
//        left = _0
//        right = _1
//    }
//
//    _5.apply {
//        right = _6
//    }

    val root = TreeNode(1)
    val _3_1 = TreeNode(3)
    val _3_2 = TreeNode(3)
    val _1 = TreeNode(1)

    root.apply {
        right = _3_1
    }

    _3_1.apply {
        right = _1
    }

    _1.apply {
        right = _3_2
    }

    val obj = CountNodeEqualToSubTree()
    println(obj.averageOfSubtree(root))
}
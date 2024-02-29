package leetcode_problem_897

class BestAnswer3 {
    fun increasingBST(root: TreeNode?): TreeNode? {
        var head: TreeNode? = null

        fun build(root: TreeNode?) {
            root?.apply {
                build(right)
                right = head
                head = this
                build(left)
                left = null
            }
        }

        build(root)

        return head
    }
}

fun main() {
    val obj = BestAnswer3()
    val _1 = TreeNode(1)
    val _2 = TreeNode(2)
    val _3 = TreeNode(3)
    val _4 = TreeNode(4)
    val _5 = TreeNode(5)
    val _6 = TreeNode(6)
    val _7 = TreeNode(7)
    val _8 = TreeNode(8)
    val _9 = TreeNode(9)

    _5.apply {
        left = _3
        right = _6
    }

    _3.apply {
        left = _2
        right = _4
    }

    _2.apply {
        left = _1
    }

    _6.apply {
        right = _8
    }

    _8.apply {
        left = _7
        right = _9
    }

    val res = obj.increasingBST(_5)
    println(res)
}
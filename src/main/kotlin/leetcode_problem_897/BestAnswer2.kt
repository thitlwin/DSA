package leetcode_problem_897

class BestAnswer2 {
    var cur = TreeNode(0)
    fun increasingBST(root: TreeNode?): TreeNode? {
        var ans = TreeNode(0)
        cur = ans
        inorder(root)
        return ans.right
    }

    fun inorder(node:TreeNode?) {
        if (node == null) return
        inorder(node.left)
        node.left = null
        cur.right = node
        cur = node
        inorder(node.right)
    }
}

fun main() {
    val obj = BestAnswer2()
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
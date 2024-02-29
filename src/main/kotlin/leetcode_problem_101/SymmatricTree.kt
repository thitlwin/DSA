package leetcode_problem_101

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String = diagram(this)

    private fun diagram(
        node: TreeNode?,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String {
        return node?.let {
            if (node.left == null && node.right == null) {
                "$root${node.`val`}\n"
            } else {
                diagram(node.right, "$top ", "$top┌──", "$top|") +
                        root + "${node.`val`}\n" +
                        diagram(node.left, "$bottom| ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }
}

class SymmatricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        if(root == null) return true
        return helper(root.left, root.right)
    }

    fun helper(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) return true
        else if (left == null) return false
        else if (right == null) return false

        if (left.`val` != right.`val`) return false

        return helper(left.left, right.right) && helper(left.right, right.left)
    }
}

fun main() {
    val obj = SymmatricTree()
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
        left = _3
    }

    println(_1)
    val res = obj.isSymmetric(_1)
    println(res)
}
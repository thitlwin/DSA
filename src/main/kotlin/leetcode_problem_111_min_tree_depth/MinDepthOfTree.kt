package leetcode_problem_111_min_tree_depth

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class MinDepthOfTree {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        if (root.left == null) {
            return 1 + minDepth(root.right)
        }
        if (root.right == null)
            return 1 + minDepth(root.left)
        return 1 + maxOf(minDepth(root.left), minDepth(root.right))
    }
}

fun main() {
    val one = TreeNode(1)
    val two = TreeNode(2)
    val three = TreeNode(3)
    val four = TreeNode(4)
    val five = TreeNode(5)
    val six = TreeNode(6)
    val seven = TreeNode(7)

    one.left = two
    one.right = three

    two.left = four
    three.right = five

    four.left = six
    five.right = seven

    val mindepth = MinDepthOfTree()
    println(mindepth.minDepth(one))
}
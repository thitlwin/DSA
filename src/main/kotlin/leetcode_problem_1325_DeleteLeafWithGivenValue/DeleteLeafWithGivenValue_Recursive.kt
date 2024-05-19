package leetcode_problem_1325_DeleteLeafWithGivenValue

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class DeleteLeafWithGivenValue_Recursive {
    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        if (root == null)
            return null
        root.left = removeLeafNodes(root.left, target)
        root.right = removeLeafNodes(root.right, target)
        if (root.left == null && root.right == null && root.`val` == target) {
            return null
        }
        return root
    }
}

fun main() {
    val obj = DeleteLeafWithGivenValue_Recursive()
    val n1 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(2)
        }
        right = TreeNode(3).apply {
            left = TreeNode(2)
            right = TreeNode(4)
        }
    }
    val res = obj.removeLeafNodes(n1, 2)
    println(res)
}
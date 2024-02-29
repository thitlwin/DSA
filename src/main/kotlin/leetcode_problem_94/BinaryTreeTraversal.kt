package leetcode_problem_94

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BinaryTreeTraversal {
    val result = mutableListOf<Int>()
    fun inorderTraversal(root: TreeNode?): List<Int> {
        traverse(root)
        return result
    }

    private fun traverse(root: TreeNode?) {
        if(root != null) {
            traverse(root.left)
            result.add(root.`val`)
            traverse(root.right)
        }
    }
}

fun main() {
    val one = TreeNode(1)
    val two = TreeNode(2)
    val three = TreeNode(3)
    one.right = two
    two.left = three

    val btt = BinaryTreeTraversal()
    val result = btt.inorderTraversal(one)
    println(result)
}
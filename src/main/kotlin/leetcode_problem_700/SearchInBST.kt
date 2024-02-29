package leetcode_problem_700

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
class SearchInBST {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null || root.`val` == `val`) return root
        return when {
            `val` < root.`val` -> searchBST(root.left, `val`)
            else -> searchBST(root.right, `val`)
        }
    }
}

fun main() {
    val zero = TreeNode(0)
    val one = TreeNode(1)
    val five = TreeNode(5)
    val seven = TreeNode(7)
    val eight = TreeNode(8)
    val nine = TreeNode(9)
    val ten = TreeNode(10)

    seven.left = one
    one.left = zero
    one.left = five
    seven.left = nine
    nine.left = eight
    eight.left = ten

    val tree = seven
    val obj = SearchInBST()
    println(obj.searchBST(tree, 7))
}
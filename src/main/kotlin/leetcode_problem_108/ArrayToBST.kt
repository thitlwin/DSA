package leetcode_problem_108

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

class ArrayToBST {

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) return null
        return createTree(nums)
    }

    private fun createTree(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) return null
        val index = (nums.size / 2)
        val node = TreeNode(nums[index])
        node.left = createTree(nums.sliceArray(0 until index))
        if (nums.size > 2)
            node.right = createTree(nums.sliceArray(index + 1 until nums.size))
        return node
    }
}

fun main() {
    val nums = arrayOf(1, 2, 3, 4,5).toIntArray()
    val obj = ArrayToBST()
    println(obj.sortedArrayToBST(nums))
}
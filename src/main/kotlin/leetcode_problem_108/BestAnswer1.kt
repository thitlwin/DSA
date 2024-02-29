package leetcode_problem_108

class BestAnswer1 {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if(nums == null) return null
        return createBST(nums, start = 0, end = nums.size - 1)
    }

    private fun createBST(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) return null
        val middle = start + (end - start) / 2
        val node = TreeNode(nums[middle])
        node.left = createBST(nums, start, middle-1)
        node.right = createBST(nums, middle + 1, end)
        return node
    }
}

fun main() {
    val nums = arrayOf(1, 2, 3, 4).toIntArray()
    val obj = BestAnswer1()
    println(obj.sortedArrayToBST(nums))
}
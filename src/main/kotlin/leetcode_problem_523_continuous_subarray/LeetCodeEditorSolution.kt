package leetcode_problem_523_continuous_subarray

class LeetCodeEditorSolution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        var prefixMod = 0
        val modSeen = HashMap<Int, Int>()
        modSeen[0] = -1
        for (i in nums.indices) {
            prefixMod = (prefixMod + nums[i]) % k
            if (modSeen.containsKey(prefixMod)) {
                // ensure that the size of subarray is at least 2
                if (i - modSeen[prefixMod]!! > 1) {
                    return true
                }
            } else {
                // mark the value of prefixMod with the curretn index
                modSeen[prefixMod] = i
            }
        }
        return false
    }
}

fun main() {
    val obj = LeetCodeEditorSolution()
//    println(obj.checkSubarraySum(intArrayOf(0, 1, 0, 3, 0, 4, 0, 4, 0), 5))
//    println(obj.checkSubarraySum(intArrayOf(0), 1))
//    println(obj.checkSubarraySum(intArrayOf(23, 2, 6, 2, 5), 6))
//    println(obj.checkSubarraySum(intArrayOf(23, 2, 6, 4, 7), 13))
//    println(obj.checkSubarraySum(intArrayOf(23, 2, 4, 6, 7), 6))
//    println(obj.checkSubarraySum(intArrayOf(23, 2, 6, 4, 7), 6))
//    println(obj.checkSubarraySum(intArrayOf(23, 2, 4, 6, 6), 7))
}
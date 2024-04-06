package leetcode_problem_41_find_missing_positive

class FindMissingPositive {
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size
        val seen = BooleanArray(n + 1)
        nums.forEach {
            if (it in 1..n) {
                seen[it] = true
            }
        }
        for (i in 1..n) {
            if (!seen[i])
                return i
        }
        return n + 1
    }
}
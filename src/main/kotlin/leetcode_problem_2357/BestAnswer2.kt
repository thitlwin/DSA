package leetcode_problem_2357

class BestAnswer2 {
    fun minimumOperations(nums: IntArray): Int {
        val resultMap = mutableMapOf<Int, Int>()

        for (i in nums) {
            if (i == 0) continue
            val existing = resultMap[i]
            if (existing == null) {
                resultMap[0] = (resultMap[0] ?: 0) + 1
                resultMap[i] = 1
            }
        }

        return resultMap[0] ?: 0
    }
}
fun main() {
    val obj = BestAnswer2()
    val res = obj.minimumOperations(intArrayOf(1, 5, 0, 3, 5))
    println(res)
}
package leetcode_problem_1_2sums

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numIndices = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, i ->
            val complement = target - i
            if (complement in numIndices)
                return intArrayOf(numIndices[complement]!!, i)

            numIndices[i] = index
        }
        return intArrayOf()
    }
}

fun main() {
    val obj = TwoSum()
    val res = obj.twoSum(intArrayOf(-1,-2,-3,-4,-5), -8)
    println(res.joinToString())
}
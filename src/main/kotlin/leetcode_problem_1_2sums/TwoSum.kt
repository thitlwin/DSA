package leetcode_problem_1_2sums

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numIndices = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, num ->
            val complement = target - num
            if (complement in numIndices)
                return intArrayOf(numIndices[complement]!!, index)

            numIndices[num] = index
        }
        return intArrayOf()
    }
}

fun main() {
    val obj = TwoSum()
//    val res = obj.twoSum(intArrayOf(-1,-2,-3,-4,-5), -8)
    val res = obj.twoSum(intArrayOf(3,1,1,2), 5)

    println(res.joinToString())
}
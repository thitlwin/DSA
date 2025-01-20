package leetcode_problem_1_2sums

class TwoSum2 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hm = HashMap<Int,Int>()
        nums.forEachIndexed { index, num ->
            val complement = target - num
            if(hm[complement] != null) {
                return intArrayOf(hm[complement]!!, index)
            }
            hm[num] = index
        }
        return intArrayOf()
    }
}

fun main() {
    val obj = TwoSum2()
    val res = obj.twoSum(intArrayOf(3,1,1,2), 5)
    println(res.joinToString())
}
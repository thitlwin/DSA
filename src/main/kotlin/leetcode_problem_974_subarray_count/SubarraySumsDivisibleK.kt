package leetcode_problem_974_subarray_count
// Got TLE error
class SubarraySumsDivisibleK {
    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        var result = 0
        for(i in nums.indices) {
            var sum = nums[i]
            for(j in i+1 until nums.size) {
                sum += nums[j]
                if(sum % k == 0){
                    result++
                }
            }
            if(nums[i] % k == 0)
                result++
        }
        return result
    }
}

fun main() {
    val obj = SubarraySumsDivisibleK()
    println(obj.subarraysDivByK(intArrayOf(4,5,0,-2,-3,1), 5))
}
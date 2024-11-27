package leetcode_problem_523_continuous_subarray
// Invalid anser
class IsGoodSubArray {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        var first = 0
        var second = 1
        var sum = nums[first]
        var total = nums[first]
        while (second < nums.size) {
            sum += nums[second]
            total += nums[second]
            if (sum % k == 0)
                return true
            if (sum > k) {
                first++
                second++
                sum = nums[first]
                if(total % k == 0)
                    return true
            } else if (sum < k) {
                second++
            } else {
                return true
            }
        }
        if (total == 0) return false
        return total % k == 0
    }
}

fun main() {
    val obj = IsGoodSubArray()
//    println(obj.checkSubarraySum(intArrayOf(0,1,0,3,0,4,0,4,0), 5))

    println(obj.checkSubarraySum(intArrayOf(0), 1))
    println(obj.checkSubarraySum(intArrayOf(23,2,6,2,5), 6))
    println(obj.checkSubarraySum(intArrayOf(23,2,6,4,7), 13))
    println(obj.checkSubarraySum(intArrayOf(23,2,4,6,7), 6))
    println(obj.checkSubarraySum(intArrayOf(23,2,6,4,7), 6))
    println(obj.checkSubarraySum(intArrayOf(23,2,4,6,6), 7))

}
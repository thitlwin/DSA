package leetcode_problem_930_BinaryArrayWithSum

class UsingSlidingWindow {
    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
        var left1 = 0
        var left2 = 0
        var sum1 = 0
        var sum2 = 0
        var right = 0
        var result = 0
        while (right < nums.size){
            sum1 += nums[right]
            sum2 += nums[right]
            while (left1 <= right && sum1 > goal){
                sum1 -= nums[left1++]
            }
            while (left2 <= right && sum2 >= goal){
                sum2 -= nums[left2++]
            }
            result += left2 - left1
            ++right
        }
        return result
    }
}
fun main() {
    val obj = UsingSlidingWindow()
//    println(obj.numSubarraysWithSum(intArrayOf(0,0,0,0,0,0,1,0,0,0), 0))
    println(obj.numSubarraysWithSum(intArrayOf(1,0,1,0,1), 2))
}
package leetcode_problem_930_BinaryArrayWithSum
// Incorrect Answer
class BinaryArrayWithSum {
    var counter = 0
    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
        if(nums.all { it == 0 } && goal == 0)
        {
            var size = nums.size
            while (size > 1){
                size--
                counter++
            }
        } else if(nums.all { it == 1 } && goal == nums.size){
            return 1
        } else {
            for(end in 1..nums.size) {
                countSubArray(end, nums, goal)
            }
        }
        return counter
    }

    private fun countSubArray(end: Int,nums: IntArray, goal: Int) {
        for (start in nums.indices)
        {
            var subArrayTotal = 0
            for(i in start .. nums.size - end){
                subArrayTotal += nums[i]
            }
            if(subArrayTotal == goal)
                counter++
        }
    }
}

fun main() {
    val obj = BinaryArrayWithSum()
    println(obj.numSubarraysWithSum(intArrayOf(0,0,0,0,0,0,1,0,0,0), 0))
}
package leetcode_problem_540_BinarySearch

class SingleElementInSingleArray {
    fun singleNonDuplicate(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        var result = -1
        while(left <= right) {
            val mid = (right + left)/2
            if(toTheLeft(nums, mid)) {
                right = mid - 1
                result = mid
            } else {
                left = mid + 1
            }
        }
        return nums[result]
    }

    private fun toTheLeft(nums: IntArray, mid: Int): Boolean {
        if(mid == nums.size - 1)
            return true
        return if(mid % 2 == 0)
            nums[mid] != nums[mid + 1]
        else
            nums[mid - 1] != nums[mid]
    }
}

fun main() {
    val obj = SingleElementInSingleArray()
//    println(obj.singleNonDuplicate(intArrayOf(1,1,2,3,3,4,4)))
    println(obj.singleNonDuplicate(intArrayOf(1,1,2,2,3,3,4,4))) // 0
}
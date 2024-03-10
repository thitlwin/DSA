package leetcode_problem_2540

class CommonElement {
    fun getCommon(nums1: IntArray, nums2: IntArray): Int {
        if(nums1.size > nums2.size) {
            return getCommon(nums2, nums1)
        }

        for(num in nums1){
            if(binarySearch(num, nums2)){
                return num
            }
        }
        return -1
    }

    private fun binarySearch(target: Int, nums: IntArray): Boolean {
        var left = 0
        var right = nums.size - 1
        while(left <= right) {
            val mid = left + (right-left)/2
            if(target > nums[mid]){
                left = mid + 1
            } else if(target < nums[mid]){
                right = mid - 1
            } else
                return true
        }
        return false
    }
}

fun main() {
    val obj = CommonElement()
    val n1 = intArrayOf(1,2,3,6)
    val n2 = intArrayOf(2,3,4,5)
    println(obj.getCommon(n1, n2))
}
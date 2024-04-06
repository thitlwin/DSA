package leetcode_problem_713_subarray_product_less_than_k

class SubArrayProductLessThanK {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        var l = 0
        var product = nums[0]
        var count = 0
        for(r in 1 until nums.size) {
            product *= nums[r]
            if(product < k) {
                count++
            } else {
                product /= nums[l++]
            }
        }

        while (l < nums.size - 2) {
            product /= nums[l++]
            if (product < k)
                count++
        }

        for(element in nums) {
            if(element < k)
                count++
        }

        return count
    }
}

fun main() {
    val obj = SubArrayProductLessThanK()
    println(obj.numSubarrayProductLessThanK(intArrayOf(10,5,2,6), 100))
//    println(obj.numSubarrayProductLessThanK(intArrayOf(1,1,1), 2))

}
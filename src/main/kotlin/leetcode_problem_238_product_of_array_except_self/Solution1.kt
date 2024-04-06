package leetcode_problem_238_product_of_array_except_self

class Solution1 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var leftProduct = 1
        for (i in nums.indices){
            result[i] = leftProduct
            leftProduct *= nums[i]
        }

        var rightProduct = 1
        for (i in nums.size-1 downTo 0){
            result[i] *= rightProduct
            rightProduct *= nums[i]
        }

        return result
    }
}

fun main() {
    val obj = Solution1()
//    println(obj.productExceptSelf(intArrayOf(-1,1,-3,3)).joinToString())
//    println(obj.productExceptSelf(intArrayOf(2,3,4,5)).joinToString())
//    println(obj.productExceptSelf(intArrayOf(1,3,5,7,0)).joinToString())
    println(obj.productExceptSelf(intArrayOf(2,4,0,6,8)).joinToString())

}
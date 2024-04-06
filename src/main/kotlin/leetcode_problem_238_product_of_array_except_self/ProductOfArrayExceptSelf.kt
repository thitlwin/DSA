package leetcode_problem_238_product_of_array_except_self

class ProductOfArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var prod = 1
        nums.forEach{
            prod *= it
        }

        for (j in nums.indices) {
            if (nums[j] == 0)
                result[j] = prod
            else
                result[j] = prod / nums[j]
        }
        return result
    }
}

fun main() {
    val obj = ProductOfArrayExceptSelf()
    println(obj.productExceptSelf(intArrayOf(-1,1,0,-3,3)).joinToString())
}
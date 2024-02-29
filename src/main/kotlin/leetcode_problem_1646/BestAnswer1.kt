package leetcode_problem_1646

class BestAnswer1 {
    fun maxProduct(nums: IntArray): Int {
        if (nums.size == 2) return (nums[0] - 1) * (nums[1] - 1)
        var a = 0
        var b = 0
        for (num in nums) {
            if (num > a) {
                b = a
                a = num
                continue
            }
            if (num > b) {
                b = num
            }
        }
        return (a - 1) * (b - 1)
    }
}

fun main() {
    val obj = BestAnswer1()
    val res = obj.maxProduct(intArrayOf(3,4,5,2))
    println(res)
}
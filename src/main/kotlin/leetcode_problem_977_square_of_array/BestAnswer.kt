package leetcode_problem_977_square_of_array

class BestAnswer {
    fun sortedSquares(nums: IntArray): IntArray {
        var sortedSquare = IntArray(nums.size)
        var l = 0
        var r = nums.size - 1
        var k = nums.size - 1
        while (l <= r) {
            val lSquare = nums[l] * nums[l]
            val rSquare = nums[r] * nums[r]
            if (lSquare > rSquare){
                sortedSquare[k--] = lSquare
                l++
            } else {
                sortedSquare[k--] = rSquare
                r--
            }
        }
        return sortedSquare
    }
}

fun main() {
    val obj = BestAnswer()
//        println(obj.sortedSquares(intArrayOf(-4,-1,0,3,10)).joinToString())
    println(obj.sortedSquares(intArrayOf(-10000,-1,0,3,10000)).joinToString())
//    println(obj.sortedSquares(intArrayOf(-4,-4,-3)).joinToString())
}
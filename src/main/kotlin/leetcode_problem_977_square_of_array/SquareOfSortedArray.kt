package leetcode_problem_977_square_of_array

class SquareOfSortedArray {
    fun sortedSquares(nums: IntArray): IntArray {
        return nums.map { it * it }.sorted().toIntArray()
    }
}

fun main() {
    val obj = SquareOfSortedArray()
    println(obj.sortedSquares(intArrayOf(-4,-1,0,3,10)).joinToString(","))
}
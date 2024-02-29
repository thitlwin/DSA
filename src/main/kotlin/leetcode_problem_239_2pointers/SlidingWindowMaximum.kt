package leetcode_problem_239_2pointers

class SlidingWindowMaximum {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val result = mutableListOf<Int>()
        result.add(nums.slice(0 until k).max())
        for (r in k until nums.size) {
            val l = r - k
            result.add(nums.sliceArray(l until r+1).max())
        }
        return result.toIntArray()
    }

}

fun main() {
    val obj = SlidingWindowMaximum()
    println(obj.maxSlidingWindow(intArrayOf(7, 2, 89, 3, 7, 4, 8), 3).joinToString())
}
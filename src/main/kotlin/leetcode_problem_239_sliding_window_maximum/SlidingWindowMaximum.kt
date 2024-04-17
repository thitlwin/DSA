package leetcode_problem_239_sliding_window_maximum

class SlidingWindowMaximum {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val queue = ArrayDeque<Int>()
        val res = ArrayList<Int>()
        for (i in nums.indices) {
            while (!queue.isEmpty() && nums[queue.last()] <= nums[i]){
                queue.removeLast()
            }
            queue.add(i)
            // remove first element if it's outside the window
            if (queue.first() == i-k){
                queue.removeFirst()
            }
            // if window has k elements add to results (first k-1 windows have < k elements because we start from empty window and add 1 element each iteration)
            if (i >= k-1) {
                res.add(nums[queue.first()])
            }
        }
        return res.toIntArray()
    }
}

fun main() {
    val obj = SlidingWindowMaximum()
//    val res = obj.maxSlidingWindow(intArrayOf(1,3,-1,-3,5,3,6,7), 3)
    val res = obj.maxSlidingWindow(intArrayOf(1,-1), 1)
    println(res.joinToString())
}
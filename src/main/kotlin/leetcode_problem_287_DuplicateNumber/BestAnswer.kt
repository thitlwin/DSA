package leetcode_problem_287_DuplicateNumber

class BestAnswer {
    fun findDuplicate(nums: IntArray): Int {
        var low = 0
        var high = nums.size - 1
        while (low < high) {
            val mid = (low + high) / 2
            var count = 0
            nums.forEach {
                if (it <= mid)
                    count++
            }
            if (count > mid) {
                high = mid
            } else {
                low = mid + 1
            }
        }
        return low
    }
}

fun main() {
    val obj = BestAnswer()
    println(obj.findDuplicate(intArrayOf(1,3,4,2,2)))
//    println(obj.findDuplicate(intArrayOf(3,3,3,3)))
}
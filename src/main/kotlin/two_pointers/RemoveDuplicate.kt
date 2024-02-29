package two_pointers

// Leetcode problem 26
class RemoveDuplicate {
    fun removeDuplicates(nums: IntArray): Int {
        var slow = 0
        for (fast in 1 until nums.size) {
            if (nums[slow] != nums[fast]) {
                slow++
                nums[slow] = nums[fast]
            }
        }
        return slow + 1
    }
}

fun main() {
    val obj = RemoveDuplicate()
    println(obj.removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 1, 2, 2))) // 3
    println(obj.removeDuplicates(intArrayOf(1, 2, 3))) // 3
    println(obj.removeDuplicates(intArrayOf(1, 1, 1))) // 1
}
package two_pointers.leet_283_move_zeros

class MoveZeros {
    fun moveZeroes(nums: IntArray): IntArray {
        var slow = 0
        for (fast in nums.indices) {
            if (nums[fast] == 0) continue
            else {
                val slowVal = nums[slow]
                nums[slow] = nums[fast]
                nums[fast] = slowVal
                slow++
            }
        }
        return nums
    }
}

fun main() {
    val obj = MoveZeros()
//    val res = obj.moveZeroes(intArrayOf(1,0,3,0,4,0))
    val res = obj.moveZeroes(intArrayOf(1))

    println(res.joinToString())
}
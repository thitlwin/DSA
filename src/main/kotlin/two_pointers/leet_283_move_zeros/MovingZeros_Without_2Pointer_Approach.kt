package two_pointers.leet_283_move_zeros

class MovingZeros_Without_2Pointer_Approach {
    fun moveZeroes(nums: IntArray): Unit {
        var i = 0
        nums.forEach {
            if (it != 0) {
                nums[i] = it
                i++
            }
        }// TC=O(n)
        while (i < nums.size) {
            nums[i] = 0
            i++
        }// TC=O(n), if all element of nums is zeros.
    }
}

fun main() {
    val obj = MovingZeros_Without_2Pointer_Approach()
    val nums = intArrayOf(1,0,1)
    obj.moveZeroes(nums)
    println(nums.joinToString())
}
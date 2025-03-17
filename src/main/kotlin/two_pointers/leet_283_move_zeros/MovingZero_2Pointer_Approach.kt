package two_pointers.leet_283_move_zeros

class MovingZero_2Pointer_Approach {
    fun moveZeroes(nums: IntArray): Unit {
        var fast = 0
        var slow = 0
        while(fast < nums.size) {
            if(nums[fast] != 0) {
                if(fast != slow) {
                    val temp = nums[slow]
                    nums[slow] = nums[fast]
                    nums[fast] = temp
                }
                slow++
            }
            fast++
        }
    }
}
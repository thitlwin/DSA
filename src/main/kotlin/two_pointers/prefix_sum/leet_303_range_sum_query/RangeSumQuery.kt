package two_pointers.prefix_sum.leet_303_range_sum_query
// TC=O(n), SC=O(1), this approach is not efficient for multiple queries
// should use the prefix sum approach
class RangeSumQuery(nums: IntArray) {
    lateinit var nums: IntArray

    init {
        this.nums = nums
    }

    fun sumRange(left: Int, right: Int): Int {
        var result = 0
        for (i in left..right) {
            result += nums[i]
        }
        return result
    }
}

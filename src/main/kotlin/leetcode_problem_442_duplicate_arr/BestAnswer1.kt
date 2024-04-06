package leetcode_problem_442_duplicate_arr

class BestAnswer1 {
//    fun findDuplicates(nums: IntArray): List<Int> {
//        val n = nums.size
//        for (i in 0 until n) {
//            while (nums[i] != nums[nums[i] - 1]) {
//                swap(nums, i, nums[i] - 1)
//            }
//        }
//        val result = ArrayList<Int>()
//        for (i in 0 until n) {
//            if (nums[i] != i + 1) {
//                result.add(nums[i])
//            }
//        }
//        return result
//    }

    fun findDuplicates(nums: IntArray): List<Int> {
        for(i in nums.indices) {
            while(nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i]-1)
            }
        }

        val result = ArrayList<Int>()
        for(i in nums.indices) {
            if(nums[i] != i + 1) {
                result.add(nums[i])
            }
        }

        return result
    }
    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}

fun main() {
    val obj = BestAnswer1()
    val res = obj.findDuplicates(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1))
    println(res.joinToString())
}
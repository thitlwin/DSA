package leetcode_problem_287_DuplicateNumber

class FindDuplicateNumber {
    fun findDuplicate(nums: IntArray): Int {
        val sortedArr = nums.sorted()
        var prev = 0
        sortedArr.forEach{
            if(prev == it)
                return it
            prev = it
        }
        return 0
    }
}
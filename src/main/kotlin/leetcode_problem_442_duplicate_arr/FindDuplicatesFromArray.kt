package leetcode_problem_442_duplicate_arr

import kotlin.math.pow

class FindDuplicatesFromArray {
    fun findDuplicates(nums: IntArray): List<Int> {
        val solArray = BooleanArray(10.0.pow(5).toInt() + 1)
        val result = ArrayList<Int>()
        nums.forEach {
            if(solArray[it])
                result.add(it)
            else
                solArray[it] = true
        }
        return result
    }
}
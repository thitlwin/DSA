package leetcode_problem_349

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.math.min

class UsingSortAnd2Pointers {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        Arrays.sort(nums1)
        Arrays.sort(nums2)
        var first = 0
        var second = 0
        val result = HashSet<Int>()
        while(first < nums1.size && second < nums2.size){
            if(nums1[first] == nums2[2]){
                result.add(nums1[first])
            } else if(nums1[first] < nums2[2]){
                first++
            } else {
                second++
            }
        }
        return result.toIntArray()
    }
}
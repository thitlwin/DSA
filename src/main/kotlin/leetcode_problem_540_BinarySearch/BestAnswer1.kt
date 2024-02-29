package leetcode_problem_540_BinarySearch
// This solution has O(n) T.C
class BestAnswer1 {
    fun singleNonDuplicate(nums: IntArray): Int {
        var ans = 0
        for (num in nums) {
            ans = ans.xor(num)
        }
        return ans
    }
}

fun main() {
    val obj = BestAnswer1()
//    println(obj.singleNonDuplicate(intArrayOf(1,1,2,3,3,4,4))) // 2
//    println(obj.singleNonDuplicate(intArrayOf(1,1,3,4,4))) // 9
    println(obj.singleNonDuplicate(intArrayOf(1,1,3,4,4,5))) // 9

}
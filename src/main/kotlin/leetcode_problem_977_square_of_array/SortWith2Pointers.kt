package leetcode_problem_977_square_of_array

class SortWith2Pointers {
    fun sortedSquares(nums: IntArray): IntArray {
//        val squared = nums.map{it * it}.toIntArray()
        val squared = IntArray(nums.size)
        for(i in nums.indices){
            squared[i] = nums[i] * nums[i]
        }

        if (nums.size <= 1)
            return squared
        var l = 0
        var r = 1
        while(l < r){
            while (r < nums.size){
                if (squared[r] < squared[l]){
                    val temp = squared[l]
                    squared[l] =squared[r]
                    squared[r] = temp
                }
                r++
            }
            l++
            r=l+1
        }
        return squared
    }
}

fun main() {
    val obj = SortWith2Pointers()
//    println(obj.sortedSquares(intArrayOf(-4,-1,0,3,10)).joinToString())
//    println(obj.sortedSquares(intArrayOf(-10000,-1,0,3,10000)).joinToString())
    println(obj.sortedSquares(intArrayOf(-4,-4,-3)).joinToString())
}
package leetcode_problem_349

class ArrayIntersection {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val hs1 = nums1.toSet()
        val hs2 = nums2.toSet()
        return hs1.intersect(hs2).toIntArray()
    }
}

fun main() {
    val obj = ArrayIntersection()
    println(obj.intersection(intArrayOf(1,2,3,4,5,6), intArrayOf(4,4,4,5)).joinToString())
}
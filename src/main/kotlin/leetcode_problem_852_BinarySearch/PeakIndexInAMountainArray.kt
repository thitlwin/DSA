package leetcode_problem_852_BinarySearch

class PeakIndexInAMountainArray {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        if (arr.size == 3) return 1
        var l = 0
        var r = arr.size - 1
        while (l <= r) {
            val mid = l + (r - l) / 2
            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return l
    }
}

fun main() {
    val obj = PeakIndexInAMountainArray()
    println(obj.peakIndexInMountainArray(intArrayOf(0, 1, 2, 3, 2, 1, 0))) // 3
    println(obj.peakIndexInMountainArray(intArrayOf(0, 10, 3, 2, 1, 0))) // 1
    println(obj.peakIndexInMountainArray(intArrayOf(0, 1, 2, 3, 3, 2, 1, 0))) // 3
}
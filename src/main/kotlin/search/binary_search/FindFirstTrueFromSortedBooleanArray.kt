package search.binary_search

class FindFirstTrueFromSortedBooleanArray {
    fun findBoundary(list: List<Boolean>): Int {
        var left = 0
        var right = list.size - 1
        var result = -1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (list[mid]) {
                result = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return result
    }
}

fun main() {
    val obj = FindFirstTrueFromSortedBooleanArray()
    println(obj.findBoundary(arrayListOf(false, false, true, true, true, true, true, true, true, true, true, true)))
}
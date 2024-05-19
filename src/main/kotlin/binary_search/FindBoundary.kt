package binary_search

class FindBoundary {
    fun findBoundary(list: List<Boolean>): Int {
        var left = 0
        var right = list.size - 1
        var boundaryIndex = -1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (list[mid]) {
                boundaryIndex = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return boundaryIndex
    }
}

fun main() {
    val obj = FindBoundary()
//    println(obj.findBoundary(listOf(false, false, true, true, true)))
    println(obj.findBoundary(listOf(false, false, false, true, true, true)))
}
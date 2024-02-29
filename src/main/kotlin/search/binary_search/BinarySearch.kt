package search.binary_search

class BinarySearch {
    fun search(list: List<Int>, target: Int): Int {
        var left = 0
        var right = list.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (list[mid] == target) return mid
            if (list[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return -1
    }
}

fun main() {
    val obj = BinarySearch()
    val position = obj.search(listOf(1,2,3,4,5,6,7,8), 9)
    println(position)
}
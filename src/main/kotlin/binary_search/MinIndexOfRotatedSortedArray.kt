package binary_search

class MinIndexOfRotatedSortedArray {
    fun findMinRotated(list: List<Int>): Int {
        var l = 0
        var r = list.size - 1
        var result = -1
        while (l <= r) {
            val mid = l + (r - l) / 2
            if (list[mid] <= list[list.size - 1]) {
                result = mid
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return result
    }
}

fun main() {
    val obj = MinIndexOfRotatedSortedArray()
//    val res = obj.findMinRotated(listOf(30,40,50,10,20))
    val res = obj.findMinRotated(listOf(0,1,2,3,4))
    println(res)
}
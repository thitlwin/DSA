package binary_search

class FindFirstOccurrence {
    fun findFirstOccurrence(list: List<Int>, target: Int): Int {
        var left = 0
        var right = list.size - 1
        var boundaryIndex = -1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (list[mid] >= target) {
                if (list[mid] == target)
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
    val obj = FindFirstOccurrence()
    val res = obj.findFirstOccurrence(listOf(1,3,3,3,6,10,10,100), 3)
//    val res = obj.findFirstOccurrence(listOf(1 ,1 ,1 ,1), 1)
//    val res = obj.findFirstOccurrence(listOf(1, 22, 22, 33, 50, 100, 20000), 33)
//    val res = obj.findFirstOccurrence(listOf(4, 6, 7, 7, 7, 20), 8)
    println(res)
}
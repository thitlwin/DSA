package binary_search

class FirstElementNotSmallerThanTarget {
    fun firstNotSmaller(list: List<Int>, target: Int): Int {
        var left = 0
        var right = list.size - 1
        var boundaryIndex = -1
        while (left <= right) {
            val mid = left + (right - left)/2
            if (list[mid] >= target) {
                boundaryIndex = mid
                right = mid - 1
            } else{
                left = mid + 1
            }
        }
        return boundaryIndex
    }
}

fun main() {
    val obj = FirstElementNotSmallerThanTarget()
    val res = obj.firstNotSmaller(listOf(1,2,4,6,8),3)
    println(res)
}
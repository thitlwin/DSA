package binary_search

class PeakOfMountainArray {

    fun peakOfMountainArray(list: List<Int>): Int {
        var left = 0
        var right = list.size - 1
        var result = -1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (mid == list.size - 1 || list[mid] > list[mid + 1]) {
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
    val obj = PeakOfMountainArray()
    val res = obj.peakOfMountainArray(listOf(1)) // 0
//    val res = obj.peakOfMountainArray(listOf(1,2,3,1)) // 2
//    val res = obj.peakOfMountainArray(listOf(0,10,3,2,1,0))//1
//    val res = obj.peakOfMountainArray(listOf(0,10,0))//1
//    val res = obj.peakOfMountainArray(listOf(0, 1 ,2, 12, 22, 32, 42, 52 ,62 ,72 ,82 ,92 ,102 ,112, 122 ,132, 133 ,132 ,111, 0))//16

    println(res)
}
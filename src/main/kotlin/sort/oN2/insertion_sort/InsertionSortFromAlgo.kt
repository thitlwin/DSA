package sort.oN2.insertion_sort

class InsertionSortFromAlgo {
    fun sort(unsorted: ArrayList<Int>): List<Int> {
        for (i in unsorted.indices) {
            var current = i
            while (current > 0 && unsorted[current] < unsorted[current-1]) {
                val temp = unsorted[current]
                unsorted[current] = unsorted[current-1]
                unsorted[current-1] = temp
                current--
            }
        }
        return unsorted
    }
}

fun main() {
    val obj = InsertionSortFromAlgo()
//    val sortedList = obj.sort(arrayListOf(0,9,0,2,4,8,5,1))
    val sortedList = obj.sort(arrayListOf(4,3,2,1,0))
    println(sortedList)
}
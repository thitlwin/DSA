package sort.insertion_sort

class InsertionSort {
    fun sort(unsorted: ArrayList<Int>): List<Int> {
        for (i in unsorted.indices) {
            var current = i
            while (current >0 && unsorted[current] < unsorted[current-1]) {
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
    val obj = InsertionSort()
    val sortedList = obj.sort(arrayListOf(0,9,0,2,4,8,5,1))
    println(sortedList)
}
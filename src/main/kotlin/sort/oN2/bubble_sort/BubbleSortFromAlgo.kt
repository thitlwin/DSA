package sort.oN2.bubble_sort

class BubbleSortFromAlgo {
    fun sortList(unsortedList: ArrayList<Int>): List<Int> {
        val n = unsortedList.size
        for (i in n - 1 downTo 1) {
            var swapped = false
            for (j in 0 until i) {
                if (unsortedList[j] > unsortedList[j + 1]) {
                    val temp = unsortedList[j]
                    unsortedList[j] = unsortedList[j + 1]
                    unsortedList[j + 1] = temp
                    swapped = true
                }
            }
            if (!swapped)
                return unsortedList
        }
        return unsortedList
    }
}

fun main() {
    val obj = BubbleSortFromAlgo()
    val res = obj.sortList(arrayListOf(1,2,3,4))

//    val res = obj.sortList(arrayListOf(5,4,3,2,1))
//    val res = obj.sortList(arrayListOf(9,4,10,3))
    println(res.joinToString())
}
package sort.oN2.selection_sort

class SelectionsortFromAlgo {
    fun sortList(unsortedList: ArrayList<Int>): List<Int> {
        val n = unsortedList.size
        for (i in 0 until n - 1) {
            var minIndex = i
            for (j in i + 1 until n) {
                if (unsortedList[j] < unsortedList[minIndex]) {
                    minIndex = j
                }
            }
            if (i != minIndex) {
                val temp = unsortedList[i]
                unsortedList[i] = unsortedList[minIndex]
                unsortedList[minIndex] = temp
            }
        }
        return unsortedList
    }
}

fun main() {
    val obj = SelectionsortFromAlgo()
//    val list = arrayListOf(4, 3, 2, 1, 0)
//    val list = arrayListOf(5, 3, 1, 2, 4)
    val list = arrayListOf(5, 3, 2, 3)
    val res = obj.sortList(list)
    println(res.joinToString())
}
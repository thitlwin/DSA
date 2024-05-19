package sort.nLogn

class MergeSortFromAlgo {
    fun sortList(unsortedList: List<Int>): List<Int> {
        return sortListInterval(unsortedList, 0, unsortedList.size)
    }

    private fun sortListInterval(unsortedList: List<Int>, start: Int, end: Int): List<Int> {
        if (end - start <= 1) {
            return unsortedList.subList(start, end)
        }

        val midPoint = (start + end)/2
        val leftList = sortListInterval(unsortedList, start, midPoint)
        val rightList = sortListInterval(unsortedList, midPoint, end)

        val result = ArrayList<Int>()
        var leftPointer = 0
        var rightPointer = 0
        while (leftPointer < leftList.size || rightPointer < rightList.size) {
            if (leftPointer == leftList.size) {
                result.add(rightList[rightPointer])
                rightPointer++
            } else if (rightPointer == rightList.size) {
                result.add(leftList[leftPointer])
                leftPointer++
            } else if(leftList[leftPointer] <= rightList[rightPointer]) {//append smaller element from left
                result.add(leftList[leftPointer])
                leftPointer++
            } else {
                result.add(rightList[rightPointer])
                rightPointer++
            }
        }
        return result
    }
}

fun main() {
    val obj = MergeSortFromAlgo()
    val list = listOf(1,3,5,7,2,4,6)
    val res = obj.sortList(list)
    println(res.joinToString())
}
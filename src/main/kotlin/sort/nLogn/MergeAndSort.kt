package sort.nLogn

fun <T : Comparable<T>> List<T>.mergeSort(): List<T> {
    if (this.size < 2) return this
    val middle = this.size / 2

    val left = this.subList(0, middle).mergeSort()
    val right = this.subList(middle, this.size).mergeSort()
    return merge(left, right)
}

fun <T : Comparable<T>> merge(left: List<T>, right: List<T>): List<T> {
    // 1
    var leftIndex = 0
    var rightIndex = 0
    // 2
    val result = mutableListOf<T>()
    // 3
    while (leftIndex < left.size && rightIndex < right.size) {
        val leftElement = left[leftIndex]
        val rightElement = right[rightIndex]
        // 4
        if (leftElement < rightElement) {
            result.add(leftElement)
            leftIndex++
        } else if (leftElement > rightElement) {
            result.add(rightElement)
            rightIndex++
        } else {
            result.add(leftElement)
            leftIndex += 1
            result.add(rightElement)
            rightIndex += 1
        }
    }
    // 5
    if (leftIndex < left.size) {
        result.addAll(left.subList(leftIndex, left.size))
    }
    if (rightIndex < right.size) {
        result.addAll(right.subList(rightIndex, right.size))
    }
    return result
}

fun main() {
//    val list = listOf(7,2,6,3,9)
//    val list = listOf(9, 8, 7, 6, 5, 4)
    val list = listOf(1,3,5,7,2,4,6)

    println("Original: $list")
    val result = list.mergeSort()
    println("Merge sorted: $result")
}


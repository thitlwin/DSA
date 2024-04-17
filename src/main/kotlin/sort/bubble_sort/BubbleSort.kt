package sort.bubble_sort

import sort.swapAt

fun <T: Comparable<T>> MutableList<T>.bubbleSort(showPasses: Boolean = false) {
    if (this.size < 2) return
    for (end in this.size-1 downTo 1) {
        var swapped = false
        for (current in 0 until end) {
            if (this[current] > this[current + 1]) {
                this.swapAt(current, current + 1)
                swapped = true
            }
        }
        if (showPasses) println(this)
        if (!swapped) return
    }
}
fun main() {
    val list = arrayListOf(9,4,10,3)
    println("Original: $list")
    list.bubbleSort(true)
    println("Bubble sorted: $list")
}
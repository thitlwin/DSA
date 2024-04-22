package sort.oN2.insertion_sort

import sort.oN2.swapAt

fun <T: Comparable<T>> MutableList<T>.insertionSort(showPasses: Boolean = false) {
    if (this.size < 2) return
    for (current in 1 until this.size) {
        for (shifting in current downTo 1) {
            if (this[shifting] < this[shifting - 1]) {
                this.swapAt(shifting, shifting-1)
            } else{
                break
            }
        }
        if (showPasses) println(this)
    }
}

fun main() {
//    val list = arrayListOf(9,4,10,3)
    val list = arrayListOf(4,3,2,1,0)
    println("Original: $list")
    list.insertionSort(true)
    println("Bubble sorted: $list")
}
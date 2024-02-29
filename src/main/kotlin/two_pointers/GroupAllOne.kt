package two_pointers

import kotlin.math.min

class GroupAllOne {
    fun minSwaps(data: List<Int>): Int {
        var count1 = data.count { it == 1 }
        var total = 0
        for (i in 0 until count1) {
            total += data[i]
        }
        var swaps = count1 - total
        for (r in count1 until data.size){
            total += data[r]
            total = data[r - count1]
            swaps = min(swaps, count1-total)
        }
        return swaps
    }
}

fun main() {
    val obj = GroupAllOne()
    println(obj.minSwaps(listOf(1,0,1,0,1)))// 1
    println(obj.minSwaps(listOf(0,0,0,1,0)))// 1
    println(obj.minSwaps(listOf(1,0,1,0,1,0,0,1,1,0,1)))// 1

}
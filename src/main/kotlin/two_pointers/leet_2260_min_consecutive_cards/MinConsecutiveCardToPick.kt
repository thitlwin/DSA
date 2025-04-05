package two_pointers.leet_2260_min_consecutive_cards

import kotlin.math.min

class MinConsecutiveCardToPick {
    fun minimumCardPickup(cards: IntArray): Int {
        var left = 0
        var ans = Int.MAX_VALUE
        val hm = HashMap<Int, Int>(cards.size)
        for(right in cards.indices) {
            hm[cards[right]] = hm.getOrDefault(cards[right],0) + 1
            while(hm[cards[right]] == 2) {
                hm[cards[left]] = hm.getOrDefault(cards[left],0) - 1
                ans = min(ans, right - left + 1)
                left++
            }
        }
        return if (ans == Int.MAX_VALUE) -1 else ans
    }
}

fun main() {
    val obj = MinConsecutiveCardToPick()
//    println(obj.minimumCardPickup(intArrayOf(3,4,2,3,4,7))) // 4
    println(obj.minimumCardPickup(intArrayOf(95,11,8,65,5,86,30,27,30,73,15,91,30,7,37,26,55,76,60,43,36,85,47,96,6)))

}
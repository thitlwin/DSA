package two_pointers

import kotlin.math.min

class LeastConsecutiveCards {
    fun leastConsecutiveCardsToMatch(cards: List<Int>): Int {
        var window = HashMap<Int, Int>()
        var left = 0
        var shortest = cards.size + 1
        for (right in cards.indices) {
            window[cards[right]] = window.getOrDefault(cards[right],0) + 1
            while (window[cards[right]] == 2) {
                shortest = min(shortest, right - left + 1)
                window[cards[left]] = window[cards[left]]!! - 1
                left++
            }
        }
        return if(shortest != cards.size + 1) shortest else -1
    }
}

fun main() {
    val obj = LeastConsecutiveCards()
    val res = obj.leastConsecutiveCardsToMatch(listOf(7,7))//2
//    val res = obj.leastConsecutiveCardsToMatch(listOf(3,4,2,3,4,7))//4
//    val res = obj.leastConsecutiveCardsToMatch(listOf(1,0,5,3))//-1

    println(res)
}
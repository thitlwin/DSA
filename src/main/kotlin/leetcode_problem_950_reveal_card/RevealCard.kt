package leetcode_problem_950_reveal_card

class RevealCard {
    fun deckRevealedIncreasing(deck: IntArray): IntArray {
        val deque = ArrayDeque<Int>()
        deck.sort()
        for (i in deck.size - 1 downTo 0) {
            if (!deque.isEmpty()) {
                deque.addFirst(deque.removeLast())
            }
            deque.addFirst(deck[i])
        }
        val result = IntArray(deck.size)
        for (i in deck.indices){
            result[i] = deque.removeFirst()
        }
        return result
    }
}

fun main() {
    val obj = RevealCard()
//    val res = obj.deckRevealedIncreasing(intArrayOf(17,13,11,2,3,5,7))
    val res = obj.deckRevealedIncreasing(intArrayOf(17,18,20,1,3,5,7,100))
    println(res.joinToString())
}
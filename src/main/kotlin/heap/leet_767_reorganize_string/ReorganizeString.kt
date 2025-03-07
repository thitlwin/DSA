package heap.leet_767_reorganize_string

import java.util.PriorityQueue
// TC = O(n), Sc=O(n)
class ReorganizeString {
    fun reorganizeString(s: String): String {
        val n = s.length
        val charCount = mutableMapOf<Char, Int>()
        for (c in s) {
            charCount[c] = charCount.getOrDefault(c, 0) + 1
        } // TC=O(n), SC=O(k)=O(1)

        val heap = PriorityQueue<Map.Entry<Char, Int>> { a, b -> b.value - a.value }
        heap.addAll(charCount.entries)// TC= O(k.log.k), SC=O(k)=O(1)

        if (heap.peek().value > (n + 1) / 2) {
            return ""
        }

        val res = CharArray(n)
        var pointer = 0

        while (heap.isNotEmpty()) {
            val (char, count) = heap.poll() // O(log k)
            repeat(count) {// O(n)
                res[pointer] = char
                pointer += 2
                if (pointer >= n) {
                    pointer = 1
                }
            }
        }
        return String(res) // TC=SC= O(n)
    }
}

fun main() {
    val obj = ReorganizeString()
//    println(obj.reorganizeString("aab"))
    println(obj.reorganizeString("aaab"))
//    println(obj.reorganizeString("ssaab"))
//    println(obj.reorganizeString("cccddeeee"))

}
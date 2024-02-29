package graph

import java.lang.StringBuilder

class WordLadder {
    private val unvisitedWords = HashSet<String>()
    private val ALPHABETS = CharArray(26)

    init {
        for (i in 0 until 26)
            ALPHABETS[i] = (i + 'a'.code).toChar()
    }

    private fun getNeighbors(word: String): List<String> {
        val unvisitedNeighbors = ArrayList<String>()
        for (j in word.indices) {
            for (c in ALPHABETS) {
                val wordBuilder = StringBuilder(word.length)
                wordBuilder.append(word.substring(0, j))
                wordBuilder.append(c)
                wordBuilder.append(word.substring(j + 1))
                val nextWord = wordBuilder.toString()
                if (unvisitedWords.contains(nextWord)) {
                    unvisitedNeighbors.add(nextWord)
                    unvisitedWords.remove(nextWord)
                }
            }
        }
        return unvisitedNeighbors
    }

     fun wordLadder(begin: String, end: String, wordList: List<String>): Int {
        if (begin == end) return 0
        for (uw in wordList) {
            unvisitedWords.add(uw)
        }
        val queue = ArrayDeque<String>()
        queue.add(begin)
        unvisitedWords.remove(begin)
        var distance = 0
        while (queue.size > 0) {
            val n = queue.size
            distance++
            for (i in 0 until n) {
                val word = queue.removeFirst()
                for (nextWord in getNeighbors(word)) {
                    if (nextWord == end) return distance
                    queue.add(nextWord)
                }
            }
        }
        return -1
    }
}

fun main() {
    val obj = WordLadder()
//    println(obj.wordLadder("cold", "warm", listOf("cold","gold","cord", "card", "ward","warm", "tard", "sold")))//4
    println(obj.wordLadder("fool", "sage", listOf("fool", "pool", "poll" ,"pole", "pale", "sale", "sage")))//6
}
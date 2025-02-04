package graph.word_ladder

import java.util.ArrayDeque

class Leet_127_WordLadder_2 {
    val unvisitedWords = HashSet<String>()
    val ALPHABETS = CharArray(26) { 'a' + it }

    private fun getNeighbors(word: String): List<String> {
        val unvisitedNeighbors = arrayListOf<String>()
        for (j in word.indices) {
            for (c in ALPHABETS) {
                val wordBuilder = StringBuilder()
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

    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        if (beginWord == endWord) {
            return 1
        }
        // add all words in dictionary to set
        for (w in wordList) {
            unvisitedWords.add(w)
        }
        val queue = ArrayDeque<String>()
        queue.add(beginWord)
        unvisitedWords.remove(beginWord)
        var distance = 1
        while (queue.isNotEmpty()) {
            val qSize = queue.size
            distance++
            for (i in 0 until qSize) {
                val word = queue.removeFirst()
                val neighborList = getNeighbors(word)
                for (nextWord in neighborList) {
                    if (nextWord == endWord) {
                        return distance
                    }
                    queue.add(nextWord)
                }
            }
        }
        return 0
    }
}

fun main() {
    val obj = Leet_127_WordLadder_2()
    val res = obj.ladderLength("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog"))
    println(res)
}
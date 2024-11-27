package leetcode_problem_1002_common_characters

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

class FindCommonCharacter {
    fun commonChars(words: Array<String>): List<String> {
        val wordsSize = words.size
        val commonCharCounts = IntArray(26)
        val currentCharCounts = IntArray(26)
        val result = ArrayList<String>()

        for (ch in words[0]) {
            commonCharCounts[ch - 'a']++
        }

        for (i in 1 until wordsSize) {
            Arrays.fill(currentCharCounts, 0)
            for (ch in words[i]) {
                currentCharCounts[ch - 'a']++
            }

            // update the common character counts to keep the min counts
            for (letter in 0 until 26) {
                commonCharCounts[letter] = min(
                    commonCharCounts[letter],
                    currentCharCounts[letter]
                )
            }
        }

        for (letter in 0 until 26) {
            for(commonCount in 0 until commonCharCounts[letter]){
                result.add((letter + 'a'.code).toChar().toString())
            }
        }
        return result
    }

}
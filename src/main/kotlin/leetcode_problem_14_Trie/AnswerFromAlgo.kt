package leetcode_problem_14_Trie

class AnswerFromAlgo {
    fun longestCommonPrefix(strs: Array<String>): String {
        val first = strs[0]
        for(i in first.indices) {
            for(j in 1 until strs.size) {
                if(strs[j].length <= i || strs[j][i] != first[i]) {
                    return first.substring(0, i)
                }
            }
        }
        return first
    }
}

fun main() {
    val obj = AnswerFromAlgo()
    val res = obj.longestCommonPrefix(arrayOf("ab", "a"))
//    val res = obj.longestCommonPrefix(arrayOf("dog","racecar","car")) // ""
//    val res = obj.longestCommonPrefix(arrayOf("flower","flow","flight")) // ""

    println(res)
}


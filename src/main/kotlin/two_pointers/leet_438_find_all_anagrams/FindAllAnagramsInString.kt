package two_pointers.leet_438_find_all_anagrams
//TC=O(n * m), SC=O(1)
class FindAllAnagramsInString {
    fun findAnagrams(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        for (i in 0 .. s.length - p.length) { // TC=O(n-m+1)~ O(n), n is s.length, m is p.length
            val subStr = s.substring(i, i + p.length) // Extracting a substring of length m takes O(m) time.
            if(isAnagram(subStr, p))
                result.add(i)
        }
        return result
    }

    private fun isAnagram(subStr: String, p: String): Boolean {
        if (subStr.length != p.length) {
            return false
        }
        val charArr = IntArray(26)
        for (i in subStr.indices) { // fixed size, O(26) = O(1)
            charArr[subStr[i] - 'a']++
            charArr[p[i] - 'a']--
        }
        return charArr.all { it == 0 } // fixed size, O(26) = O(1)
    }
}

fun main() {
    val obj = FindAllAnagramsInString()
    val res = obj.findAnagrams("cbaebabacd", "abc")
    println(res.joinToString())
}
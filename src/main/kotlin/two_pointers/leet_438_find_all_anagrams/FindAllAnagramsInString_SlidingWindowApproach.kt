package two_pointers.leet_438_find_all_anagrams
//TC=O(s), SC=O(1)
class FindAllAnagramsInString_SlidingWindowApproach {
    fun findAnagrams(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        if (s.length < p.length) return result
        val sArr = IntArray(26)
        val pArr = IntArray(26)
        for (i in p.indices) {
            sArr[s[i] - 'a']++
            pArr[p[i] - 'a']++
        }
        if (sArr.contentEquals(pArr)) // O(26) = O(1)
            result.add(0)

        for (right in p.length until s.length) { // TC=O(s-p)
            val left = right - p.length
            sArr[s[left] - 'a']--
            sArr[s[right] - 'a']++
            if (sArr.contentEquals(pArr))// O(26) = O(1)
                result.add(left + 1)
        }
        return result
    }
}

fun main() {
    val obj = FindAllAnagramsInString_SlidingWindowApproach()
    val res = obj.findAnagrams("cbaebabacd", "abc")
    println(res.joinToString())
}
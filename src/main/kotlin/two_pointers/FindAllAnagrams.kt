package two_pointers

class FindAllAnagrams {
    fun findAllAnagrams(original: String, check: String): List<Int> {
        val originalLen = original.length
        val checkLen = check.length
        val res = mutableListOf<Int>()
        if (originalLen < checkLen) return res

        val checkCounter = IntArray(26)
        val window = IntArray(26)
        for (i in 0 until checkLen) {
            checkCounter[check[i] - 'a']++
            window[original[i] - 'a']++
        }
        if (window.contentEquals(checkCounter)) res.add(0)
        for (i in checkLen until originalLen) {
            window[original[i - checkLen] - 'a']--
            window[original[i] - 'a']++
            if (window.contentEquals(checkCounter))
                res.add(i - checkLen + 1)
        }
        return res
    }
}

fun main() {
    val obj = FindAllAnagrams()
//    val res = obj.findAllAnagrams("cbaebabacd", "abc")
//    val res = obj.findAllAnagrams("abab", "ab")
    val res = obj.findAllAnagrams("nabanabannaabbaanana", "banana")
    println(res.joinToString())
}
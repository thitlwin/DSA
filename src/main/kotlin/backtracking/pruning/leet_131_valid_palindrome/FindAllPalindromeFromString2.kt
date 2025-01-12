package backtracking.pruning.leet_131_valid_palindrome

class FindAllPalindromeFromString2 {
    fun partition(s: String): List<List<String>> {
        val result: ArrayList<List<String>> = arrayListOf()
        return dfs(s, result = result, path = arrayListOf<String>(), start = 0)
    }

    private fun dfs(
        s: String,
        result: ArrayList<List<String>>,
        path: ArrayList<String>,
        start: Int
    ): List<List<String>> {
        if (start == s.length) {
            val newList = ArrayList(path)
            result.add(newList)
            return result
        }
        for (end in start until s.length) {
            val subStr = s.substring(start, end + 1)
            if (isPalindrome(subStr)) {
                path.add(subStr)
                dfs(s, result, path, end + 1)
                path.removeLast()
            }
        }
        return result
    }

    private fun isPalindrome(s: String): Boolean {
        var l = 0
        var r = s.length - 1
        while (l < r) {
            if (s[l] != s[r]) {
                return false
            }
            l++
            r--
        }
        return true
    }
}

fun main() {
    val obj = FindAllPalindromeFromString2()
    val res = obj.partition("abc")
    println(res.joinToString())
}
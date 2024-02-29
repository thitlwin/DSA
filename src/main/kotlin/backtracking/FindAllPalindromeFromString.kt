package backtracking

class FindAllPalindromeFromString {
    fun partition(inputStr: String): List<List<String>>{
        val result = ArrayList<List<String>>()
        dfs(result, ArrayList(), inputStr, 0)
        return result
    }

    private fun dfs(result: ArrayList<List<String>>,
                    part: ArrayList<String>,
                    inputStr: String,
                    start: Int) {
        if(start == inputStr.length) {
            val li = ArrayList(part)
            result.add(li)
        }

        for (end in start until inputStr.length) {
            if (isPalindrome(inputStr.substring(start, end+1))) {
                part.add(inputStr.substring(start, end+1))
                dfs(result, part, inputStr, end+1)
                part.removeAt(part.size - 1)
            }
        }
    }

    private fun isPalindrome(str: String): Boolean {
        var l=0
        var r = str.length-1
        while (l<r){
            if (str[l] != str[r])
                return false
            l++
            r--
        }
        return true
    }
}

fun main() {
    val obj = FindAllPalindromeFromString()
    val res = obj.partition("orange")
    res.forEach { println(it) }
}
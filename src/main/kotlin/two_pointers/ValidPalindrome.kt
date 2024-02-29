package two_pointers

class ValidPalindrome {
    fun isPalindrome(str: String): Boolean {
        val charArr = str.filter { it.isLetterOrDigit() }
        var l = 0
        var r = charArr.length - 1
        while (l < r) {
            if (!charArr[l].equals(charArr[r], ignoreCase = true)) return false
            l++
            r--
        }
        return true
    }
}

fun main() {
    val obj = ValidPalindrome()
    println(obj.isPalindrome("Do geese see God?"))
}
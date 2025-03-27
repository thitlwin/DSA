package two_pointers

class ValidPalindrome_2 {
    // with filter approach for non alpha-numeric
//    fun isPalindrome(s: String): Boolean {
//        var filteredStr = s.lowercase().filter { it.isLetterOrDigit() }
//        var left = 0
//        var right = filteredStr.length - 1
//        while (left < right) {
//            if(filteredStr[left] != filteredStr[right])
//                return false
//            left++
//            right--
//        }
//        return true
//    }

    //    Without filter approach
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1
        while (left < right) {
            if (!s[left].isLetterOrDigit()) {
                left++
                continue
            }
            if (!s[right].isLetterOrDigit()) {
                right--
                continue
            }
            if (s[left].lowercase() != s[right].lowercase()) {
                return false
            }
            left++
            right--
        }
        return true
    }
}

fun main() {
    val obj = ValidPalindrome_2()
//    println(obj.isPalindrome("Do geese see God?"))
//    println(obj.isPalindrome("A brown fox jumping over"))
    println(obj.isPalindrome("A man, a plan, a canal: Panama"))
}
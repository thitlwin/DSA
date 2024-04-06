package leetcode_problem_1249_stack

class MinRemoveToMakeStrValid {
    fun minRemoveToMakeValid(s: String): String {
     val stack = ArrayDeque<Char>()
     var openCount = 0
     for (chr in s) {
         if (chr == ')' && openCount == 0) {
             continue
         }
         if (chr == '(') {
             openCount++
         } else if (chr == ')') {
             openCount--
         }
         stack.add(chr)
     }
        val result = StringBuilder()
        openCount = 0
        while (stack.isNotEmpty()) {
            val chr = stack.removeLast()
            if (chr == '(' && openCount == 0){
//                result.append(chr)
                continue
            }
            if (chr == ')') {
                openCount++
            } else if (chr == '(') {
                openCount--
            }
            result.append(chr)
        }
        return result.reverse().toString()
    }
}

fun main() {
    val obj = MinRemoveToMakeStrValid()
    println(obj.minRemoveToMakeValid("lee(t(c)o)de)"))
    println(obj.minRemoveToMakeValid("))(("))

}
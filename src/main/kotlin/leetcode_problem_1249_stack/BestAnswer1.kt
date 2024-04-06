package leetcode_problem_1249_stack
//class Solution {
//    fun minRemoveToMakeValid(s: String): String {
//        return buildString {
//            var openedCount =0
//            for(index in s.indices){
//                val char = s[index]
//                when(char){
//                    '(' ->{
//                        openedCount++
//                        append(char)
//                    }
//                    ')' -> {
//                        if(openedCount>0){
//                            openedCount--
//                            append(char)
//                        }
//                    }
//                    else -> {
//                        append(char)
//                    }
//                }
//            }
//            var index = length-1
//            while (openedCount>0){
//                if(get(index)=='('){
//                    deleteAt(index)
//                    openedCount--
//                }
//                index--
//            }
//        }
//    }
//}
class BestAnswer1 {
    fun minRemoveToMakeValid(s: String): String {
        return buildString {
            var openCount = 0
            for (char in s) {
                when(char) {
                    '(' -> {
                        openCount++
                        append(char)
                    }
                    ')' -> {
                        if (openCount > 0) {
                            openCount--
                            append(char)
                        }
                    }
                    else -> {
                        append(char)
                    }
                }
            }
            var index = length - 1
            while (openCount > 0) {
                if (get(index) == '(') {
                    deleteAt(index)
                    openCount--
                }
                index--
            }
        }
    }
}

fun main() {
    val obj = BestAnswer1()
//    println(obj.minRemoveToMakeValid("lee(t(c)o)de)"))
//    println(obj.minRemoveToMakeValid("))(("))
    println(obj.minRemoveToMakeValid("(("))
//    println(obj.minRemoveToMakeValid("a)b(c)d"))
//    println(obj.minRemoveToMakeValid("abc(((ef))"))
//    println(obj.minRemoveToMakeValid("abc((d(ef))"))
}
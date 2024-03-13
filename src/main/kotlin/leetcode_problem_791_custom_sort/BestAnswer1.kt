package leetcode_problem_791_custom_sort

class BestAnswer1 {
    fun customSortString(order: String, s: String): String {
        val frequencies = IntArray(26)
        for (element in s){
            frequencies[element -'a']++
        }
        val sb = StringBuilder()
        for (element in order){
            while (frequencies[element - 'a'] > 0){
                sb.append(element)
                frequencies[element-'a']--
            }
        }

        for (i in 0 until 26){
            while (frequencies[i] > 0){
                sb.append('a'+i)
                frequencies[i]--
            }
        }

        return sb.toString()
    }
}

fun main() {
    val obj = BestAnswer1()
    val order = "kqep"
    val str = "pekeq"
    println(obj.customSortString(order, str))
}
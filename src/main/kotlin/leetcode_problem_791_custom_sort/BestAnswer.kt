package leetcode_problem_791_custom_sort

class BestAnswer {
    fun customSortString(order: String, s: String): String {
        val charCounts = HashMap<Char, Int>()
        s.forEach { charCounts[it] = charCounts.getOrDefault(it,0) + 1 }
        val result = StringBuilder()
        order.forEach { ch->
            repeat(charCounts[ch]?:0){
                result.append(ch)
            }
            charCounts.remove(ch)
        }
        charCounts.forEach { (c, i) ->
            repeat(i) { result.append(c) }
        }
        return result.toString()
    }
}

fun main() {
    val obj = BestAnswer()
    val order = "kqep"
    val str = "pekeq"
    println(obj.customSortString(order, str))
}
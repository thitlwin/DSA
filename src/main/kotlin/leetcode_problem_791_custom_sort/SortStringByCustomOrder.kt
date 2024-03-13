package leetcode_problem_791_custom_sort

class SortStringByCustomOrder {
    fun customSortString(order: String, s: String): String {
        val hm = HashMap<Char,Int>()
        order.forEachIndexed { index, ch ->
            hm[ch] = index
        }
        val charArr = s.toCharArray()
//        for (end in (1 until s.length).reversed()) {
        for(end in s.length-1 downTo 1){
            for (i in 0 until end){
                if((hm[charArr[i]] ?: 27) > (hm[charArr[i + 1]] ?: 27)){
                    val temp = charArr[i]
                    charArr[i] = charArr[i + 1]
                    charArr[i + 1] = temp
                }
            }
        }

//        for(l in s.length - 1 downTo 0){
//            for(i in l until s.length-1) {
//                if((hm[charArr[i]] ?: 27) > (hm[charArr[i + 1]] ?: 27)){
//                    val temp = charArr[i]
//                    charArr[i] = charArr[i + 1]
//                    charArr[i + 1] = temp
//                }
//            }
//        }

        return charArr.joinToString("")
    }
}

fun main() {
    val order = "kqep"
    val str = "pekeq"
    val obj = SortStringByCustomOrder()
    println(obj.customSortString(order, str))
}
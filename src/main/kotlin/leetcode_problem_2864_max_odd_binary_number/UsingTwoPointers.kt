package leetcode_problem_2864_max_odd_binary_number

class UsingTwoPointers {
    fun maximumOddBinaryNumber(s: String): String {
        var left = 0
        var right = s.length - 1
        val charArr = s.toCharArray()
        while(left <= right){
            if(charArr[left] == '1') left++
            if(charArr[right] == '0') right--
            if(left <= right && charArr[left] == '0' && charArr[right] == '1'){
                charArr[left] = '1'
                charArr[right] = '0'
            }
        }

        charArr[left-1] = '0'
        charArr[s.length-1] = '1'

        return String(charArr)
    }
}

fun main() {
    val obj = UsingTwoPointers()
    println(obj.maximumOddBinaryNumber("100100"))
}
package two_pointers

class PrefixSumTotal {
    fun subarraySumTotal(arr: List<Int>, target: Int): Int {
        val prefixSum = HashMap<Int, Int>()
        prefixSum[0] = 1
        var curSum = 0
        var count = 0
        for (i in arr.indices){
            curSum += arr[i]
            val complement = curSum - target
            if (prefixSum.containsKey(complement)){
                count += prefixSum[complement]!!
            }
            if (prefixSum.containsKey(curSum)){
                prefixSum.replace(curSum, prefixSum[curSum]!! + 1)
            } else {
                prefixSum[curSum] = 1
            }
        }
        return count
    }
}

fun main() {
    val obj = PrefixSumTotal()
    println(obj.subarraySumTotal(listOf(1,1,1), 2))
//    println(obj.subarraySumTotal(listOf(10, 5, -5, -20, 10), -10))
}
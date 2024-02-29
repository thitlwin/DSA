package two_pointers

class PrefixSum {
    fun subarraySum(arr: List<Int>, target: Int): List<Int>? {
        val prefixSums = HashMap<Int, Int>()
        prefixSums[0] = 0
        var curSum = 0
        for (i in arr.indices) {
            curSum += arr[i]
            val complement = curSum - target
            if (prefixSums.containsKey(complement)) {
                return listOf(prefixSums[complement]!!, i + 1)
            }
            prefixSums[curSum] = i + 1
        }
        return null
    }
}

fun main() {
    val obj = PrefixSum()
    val res = obj.subarraySum(listOf(1,3,-3,8,5,7), 5) //2,4
//    val res = obj.subarraySum(listOf(1,1,1), 3)//0,3
//    val res = obj.subarraySum(listOf(1,-20,-3,30,5,7), 7)// 1,4
    println(res)
}
package two_pointers.prefix_sum

class PrefixSum_2 {
    fun subarraySum(arr: List<Int>, target: Int): List<Int>? {
        val prefixSum: HashMap<Int, Int> = hashMapOf()
        prefixSum[0] = -1
        var curSum = 0
        for (i in arr.indices) {
            curSum += arr[i]
            var complement = curSum - target
            if (prefixSum.containsKey(complement)) {
                return listOf(prefixSum[complement]!! + 1, i + 1)
            }
            prefixSum[curSum] = i
        }
        return null
    }
}

fun main() {
    val obj = PrefixSum_2()
    val res = obj.subarraySum(listOf(1, 3, -3, 8, 5, 7), 5) // 2,4
//        val res = obj.subarraySum(listOf(1,1,1), 3) //0,3
    println(res)
}
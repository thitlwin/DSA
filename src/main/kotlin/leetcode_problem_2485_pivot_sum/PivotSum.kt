package leetcode_problem_2485_pivot_sum

class PivotSum {
    fun pivotInteger(n: Int): Int {
        var i = 1
        var j = n
        var prefixSum = 1
        var suffixSum = n
        while(i < j) {
            if (prefixSum >= suffixSum) {
                suffixSum += --j
            }
            prefixSum += ++i
        }
        if(i == j && prefixSum == suffixSum)
            return i
        return -1
    }
}
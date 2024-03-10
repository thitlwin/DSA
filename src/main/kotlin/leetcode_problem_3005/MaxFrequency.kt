package leetcode_problem_3005

class MaxFrequency {
    fun maxFrequencyElements(nums: IntArray): Int {
        val frequencies = HashMap<Int, Int>()
        var maxFrequency = 0
        var totalFrequency = 0
        nums.forEach {
            frequencies[it] = frequencies.getOrDefault(it, 0) + 1
            val frequency = frequencies[it] ?: 0
            if(frequency > maxFrequency) {
                maxFrequency = frequency
                totalFrequency = frequency
            } else {
                totalFrequency += frequency
            }
        }
        return totalFrequency
    }
}
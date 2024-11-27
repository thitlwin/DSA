package backtracking.pruning.leetcode_problem_46_permutation

class ChatGptAnswer {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        generatePermutations(nums.size, nums.toMutableList(), result)
        return result
    }

    fun generatePermutations(n: Int, nums: MutableList<Int>, result: MutableList<List<Int>>) {
        if (n == 1) {
            // Base case: When there's only one element left, add the current permutation to the result.
            result.add(nums.toList())
            return
        }

        for (i in 0 until n) {
            // Swap the current element with the first element.
            nums.swap(i, n - 1)

            // Recursively generate permutations for the remaining elements.
            generatePermutations(n - 1, nums, result)

            // Swap back to the original order to explore other permutations.
            nums.swap(i, n - 1)
        }
    }

    // Extension function to swap two elements in a MutableList.
    fun MutableList<Int>.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}
fun main() {
    val obj = ChatGptAnswer()
    val nums = intArrayOf(1, 2, 3,4)
    val permutations = obj.permute(nums)
    println(permutations)
}

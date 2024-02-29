package backtracking

class ThreeSum {
    fun combinationSum(candidates: List<Int>, target: Int): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        val seq = mutableListOf<Int>()
        dfs(candidates.sorted(), target, result, seq, 0 , 0)
        return result
    }

    private fun dfs(candidates: List<Int>, target: Int, result: MutableList<List<Int>>,
                    seq: MutableList<Int>,
                    sum: Int,
                    start: Int) {
        var sum = sum
        if (sum == target) {
            result.add(seq.toList())
        }
        if (sum < target) {
            for (i in start until candidates.size) {
                sum += candidates[i]
                if (sum > target)
                    break
                seq.add(candidates[i])
                dfs(candidates, target, result, seq, sum, i)
                seq.removeLast()
                sum -= candidates[i]
            }
        }
    }
}

fun main() {
    val obj = ThreeSum()
//    val res = obj.combinationSum(listOf(2,3), 5)// 23
//    val res = obj.combinationSum(listOf(2,3,6,7), 7) // 223, 7
//    val res = obj.combinationSum(listOf(1), 1)// 1
    val res = obj.combinationSum(listOf(1), 2)// 11
    res.forEach { println(it) }
}
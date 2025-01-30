package backtracking.aggregation_and_memorization.leet_473_matchsticks_square
//This solution does not pass all cases.
class MatchsticksSquare {
    fun makesquare(matchsticks: IntArray): Boolean {
        val sum = matchsticks.sum()
        if (sum % 4 != 0) {
            return false
        }
        val sideLength = sum / 4
        val used = BooleanArray(matchsticks.size)
        matchsticks.sortDescending()
        val res = dfs(matchsticks, used, root = sideLength, sideLength, start = 0)
        return res == 4
    }

    private fun dfs(
        matchsticks: IntArray, used: BooleanArray, root: Int, sideLength: Int, start: Int
    ): Int {
        if (root == 0) {
            return 1
        }
        var accumulatedSide = 0
        for (i in start until matchsticks.size) {
            if (matchsticks[i] > sideLength) {
                return -1
            }
            if (used[i]) {
                continue
            }
            used[i] = true
            accumulatedSide += dfs(matchsticks, used, root - matchsticks[i], sideLength, start + i)
        }
        return accumulatedSide
    }
}

fun main() {
    val obj = MatchsticksSquare()
//    val res = obj.makesquare(intArrayOf(1, 1, 2, 2, 2))
    val res = obj.makesquare(intArrayOf(5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3)) // true
    println(res)
}
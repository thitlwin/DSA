package backtracking.aggregation_and_memorization.leet_473_matchsticks_square
//def makesquare(self, matchsticks: List[int]) -> bool:
//    if sum(matchsticks) % 4 != 0: return False
//    side_length = sum(matchsticks) // 4
//    matchsticks.sort(reverse=True)
//    sides = [0, 0, 0, 0]
//    def dfs(start_index):
//        if start_index == len(matchsticks):
//            return side_length == sides[0] == sides[1] == sides[2] == sides[3]
//
//        for i in range(4):
//            if sides[i] + matchsticks[start_index] <= side_length:
//                sides[i] += matchsticks[start_index]
//                if dfs(start_index + 1): return True
//                sides[i] -= matchsticks[start_index]
//        return False
//    return dfs(0)

class MatchsticksSquare_Algo_Answer {
    fun makesquare(matchsticks: IntArray): Boolean {
        val sum = matchsticks.sum()
        if (sum % 4 != 0) return false
        val sideLength = sum / 4
        matchsticks.sortDescending()
        val sides = intArrayOf(0,0,0,0)
        return dfs(matchsticks, sides, start = 0, sideLength)
    }

    private fun dfs(matchsticks: IntArray, sides: IntArray, start: Int, sideLength: Int): Boolean {
        if (start == matchsticks.size) {
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3]
        }
        var isValid = false
        for (i in 0..3) {
            if (sides[i] + matchsticks[start] <= sideLength) {
                sides[i] += matchsticks[start]
                isValid = isValid || dfs(matchsticks, sides, start + 1, sideLength)
                sides[i] -= matchsticks[start]
            }
        }
        return isValid
    }
}

fun main() {
    val obj = MatchsticksSquare_Algo_Answer()
//    val res = obj.makesquare(intArrayOf(1, 1, 2, 2, 2))
    val res = obj.makesquare(intArrayOf(5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3)) // true
    println(res)
}
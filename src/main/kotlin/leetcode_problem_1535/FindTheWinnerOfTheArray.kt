package leetcode_problem_1535

class FindTheWinnerOfTheArray {
    @OptIn(ExperimentalStdlibApi::class)
    fun getWinner(arr: IntArray, k: Int): Int {
        var winCount = 0
        val max = arr.max()
        var winner = arr[0]

        for (i in 1..<arr.size) {
            val opponent = arr[i]
            if (opponent > winner) {
                winCount = 1
                winner = opponent
            } else {
                winCount++
            }
            if (winCount == k || winner == max) {
                return winner
            }
        }
        return -1
    }
}

fun main() {
    val obj = FindTheWinnerOfTheArray()
    val res = obj.getWinner(intArrayOf(3,2,1), 2)
    println(res)
}
package leetcode_problem_79_word_search

class WordSearch {
    private var rows: Int = 0
    private var cols: Int = 0
    lateinit var targetWord: String
    lateinit var gameBoard: Array<CharArray>
    fun exist(board: Array<CharArray>, word: String): Boolean {
        rows = board.size
        cols = board[0].size
        targetWord = word
        gameBoard = board

        // iterate over every cell in the board
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                // if the first letter matches and dfs search is successful, return true
                if (dfs(i, j, 0)) {
                    return true
                }
            }
        }
        return false
    }

    private fun dfs(row: Int, col: Int, index: Int): Boolean {
        // Base case : check if we are at the last character of the word
        if (index == targetWord.length - 1) {
            return gameBoard[row][col] == targetWord[index]
        }

        // check if the current cell does not match the character at the index in word
        if (gameBoard[row][col] != targetWord[index]) {
            return false
        }

        // temporarily mark the current cell as visited by replacing its value
        val tempChar = gameBoard[row][col]
        gameBoard[row][col] = '0'

        // explore all possible adjacent cells (up, right, down, left)
        val directions = intArrayOf(-1, 0, 1, 0, -1)

        for (d in 0 until 4) {
            val newRow = row + directions[d]
            val newCol = col + directions[d + 1]

            // check if the new position is withing bounds and not visited
            if (newRow in 0 until rows &&
                newCol in 0 until cols &&
                gameBoard[newRow][newCol] != '0'
            ) {
                // if the dfs search from the adjacent cell is successful, return true
                if (dfs(newRow, newCol, index + 1)) {
                    return true
                }
            }
        }
        // reset the cell's value back from '0' to its original character
        gameBoard[row][col] = tempChar

        // If none of the adjacent cells lead to a solution, return false
        return false
    }
}

fun main() {
    val obj = WordSearch()
    val res =  obj.exist(
        arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E')
        ),
        "ABCCED"
    )
    println(res)
}
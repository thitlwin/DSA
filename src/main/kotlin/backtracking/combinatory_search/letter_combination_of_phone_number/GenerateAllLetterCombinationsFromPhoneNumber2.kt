package backtracking.combinatory_search.letter_combination_of_phone_number

class GenerateAllLetterCombinationsFromPhoneNumber2 {
    private val charMap: MutableMap<Char, CharArray> = mutableMapOf(
        '2' to charArrayOf('a', 'b', 'c'),
        '3' to charArrayOf('d', 'e', 'f'),
        '4' to charArrayOf('g', 'h', 'i'),
        '5' to charArrayOf('j', 'k', 'l'),
        '6' to charArrayOf('m', 'n', 'o'),
        '7' to charArrayOf('p', 'q', 'r', 's'),
        '8' to charArrayOf('t', 'u', 'v'),
        '9' to charArrayOf('w', 'x', 'y', 'z')
    )

    fun letterCombinations(digits: String): List<String> {
        val result = ArrayList<String>()
        return dfs(digits, path = arrayListOf<Char>(), result = result, startIndex = 0)
    }

    private fun dfs(digits: String, path: ArrayList<Char>, result: ArrayList<String>, startIndex: Int): List<String> {
        if (digits.isEmpty()) return result
        if (startIndex == digits.length) {
            result.add(path.joinToString(""))
            return result
        }

        val letters = charMap[digits[startIndex]]
        if (letters != null) {
            for (chr in letters) {
                path.add(chr)
                dfs(digits, path, result, startIndex + 1)
                path.removeAt(startIndex)
            }
        }
        return result
    }
}

fun main() {
    val obj = GenerateAllLetterCombinationsFromPhoneNumber2()
    val result = obj.letterCombinations("23")
    println(result.joinToString())
}
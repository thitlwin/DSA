package backtracking
//Given a phone number that contains digits 2-9, find all possible letter combinations the phone number could translate to.
//Input:
//"56"

//Output:
//["jm","jn","jo","km","kn","ko","lm","ln","lo"]
class GenerateAllLetterCombinationsFromPhoneNumber {
    val result = ArrayList<String>()
    val keyboard = mutableMapOf(
        Pair('2', "abc".toCharArray()),
        Pair('3', "def".toCharArray()),
        Pair('4', "ghi".toCharArray()),
        Pair('5', "jkl".toCharArray()),
        Pair('6', "mno".toCharArray()),
        Pair('7', "pqrs".toCharArray()),
        Pair('8', "tuv".toCharArray()),
        Pair('9', "wxyz".toCharArray())
        )
    fun letterCombinationsOfPhoneNumber(inputDigit: String): List<String> {
        dfs(inputDigit,0, StringBuilder())
        return result
    }

    private fun dfs(inputDigit: String, startIndex: Int, path: StringBuilder) {
        if(startIndex == inputDigit.length) {
            result.add(path.toString())
            return
        }

        val letters = keyboard[inputDigit[startIndex]]
        if (letters != null) {
            for (l in letters) {
                path.append(l)
                dfs(inputDigit, startIndex+1, path)
                path.deleteCharAt(startIndex)
            }
        }
    }
}

fun main() {
    val obj = GenerateAllLetterCombinationsFromPhoneNumber()
    val res = obj.letterCombinationsOfPhoneNumber("23")
    res.forEach { println(it) }
}
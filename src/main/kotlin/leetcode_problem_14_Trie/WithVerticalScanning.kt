package leetcode_problem_14_Trie

class WithVerticalScanning {
    fun longestCommonPrefix(strs: Array<String>): String {
        if(strs.isEmpty()) return ""
        var prefix = strs[0]
        for(col in prefix.indices) {
            val ch = prefix[col]
            for (row in 1 until strs.size) {
                if(col == strs[row].length || strs[row][col] != ch)
                    return prefix.substring(0,col)
            }
        }
        return prefix
    }
}
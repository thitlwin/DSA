package backtracking

class leet_93_restore_ip_address {
    fun restoreIpAddresses(s: String): List<String> {
        val result: ArrayList<String> = arrayListOf()
        dfs(s, result, path = arrayListOf(), start = 0)
        return result
    }

    private fun dfs(s: String, result: ArrayList<String>, path: ArrayList<String>, start: Int) {
        if(path.size == 4 && start==s.length) {
            result.add(path.joinToString("."))
            return
        }

        for(edge in getEdges(s, start)) {
            if(path.size < 4 && isValidRange(edge)) {
                path.add(edge)
                dfs(s, result, path, start + edge.length)
                path.removeLast()
            }
        }
    }

    private fun getEdges(s: String, start: Int): List<String> {
        val edges: ArrayList<String> = arrayListOf()
        for(i in start..start + 2) {
            if(i < s.length) {
                edges.add(s.substring(start, i + 1))
            }
        }
        return edges
    }

    private fun isValidRange(subStr: String): Boolean {
        val digit = subStr.toInt()
        return (subStr.length == digit.toString().length &&
                digit in 0..255)
    }
}

fun main() {
    val obj = leet_93_restore_ip_address()
    val res = obj.restoreIpAddresses("25525511135")
//    val res = obj.restoreIpAddresses("010101")
    println(res)
}
package leetcode_problem_120_triangle
class BestAnswer1 {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val table = Array(triangle.size) { i -> 0 }
        for (i in table.indices) {
            table[i] = triangle[triangle.size-1][i]
        }
        for (i in table.size-2 downTo 0) {
            for (j in 0 until triangle[i].size){
                table[j] = Math.min(table[j], table[j+1])+ triangle[i][j]
            }
        }
        return table[0]
    }
}

fun main() {
    val obj = BestAnswer1()
    val triangle = listOf(
        listOf(2), listOf(3, 4),
        listOf(6, 5, 7), listOf(4, 1, 8, 3)
    )
    println(obj.minimumTotal(triangle))
}
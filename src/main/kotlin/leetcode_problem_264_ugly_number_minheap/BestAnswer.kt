package leetcode_problem_264_ugly_number_minheap

class BestAnswer {
    fun nthUglyNumber(n: Int): Int {
        if (n == 1) return 1
        val arr = IntArray(n)
        arr[0] = 1
        var index2 = 0
        var index3 = 0
        var index5 = 0
        for (i in 1 until n){
            val ugly = minOf(arr[index2] * 2, arr[index3] * 3, arr[index5] * 5)
            arr[i] = ugly
            if (ugly == arr[index2] * 2) index2++
            if (ugly == arr[index3] * 3) index3++
            if (ugly == arr[index5] * 5) index5++
        }
        return arr[n-1]
    }
}

fun main() {
    val obj = BestAnswer()
    println(obj.nthUglyNumber(10))
}
package ugly_number

import java.util.*


class UglyNumber {
    fun uglyNumber(n: Int): Int {
        val res = ArrayList<Int>()
        val maxInt = 100// Int.MAX_VALUE
        var i = 1
        while (i <= maxInt) {
            var j = i
            while (j <= maxInt) {
                var k = j
                while (k <= maxInt) {
                    res.add(k)
                    k *= 5
                }
                j *= 3
            }
            i *= 2
        }
        Collections.sort(res)
        return res.get(n - 1)
    }
}

fun main() {
    val obj = UglyNumber()
    println(obj.uglyNumber(3))
}
package heap.leet_264_ugly_number

class UglyNumber_BruteForce {
    fun nthUglyNumber(n: Int): Int {
        val uglyNumbers = arrayListOf<Int>()
        val max = Int.MAX_VALUE
        var i = 1L
        while (i <= max) {
            var j = i
            while (j <= max) {
                var k = j
                while (k <= max) {
                    uglyNumbers.add(k.toInt())
                    k *= 5
                }
                j *= 3
            }
            i *= 2
        }
        uglyNumbers.sort()
        return uglyNumbers[n-1]
    }
}

fun main() {
    val obj = UglyNumber_BruteForce()
    println(obj.nthUglyNumber(10))
}
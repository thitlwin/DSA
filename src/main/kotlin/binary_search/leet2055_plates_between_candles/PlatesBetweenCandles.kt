package binary_search.leet2055_plates_between_candles

/*
Input: s = "**|**|***|", queries = [[2,5],[5,9]]
Output: [2,3]
Explanation:
- queries[0] has two plates between candles.
- queries[1] has three plates between candles.
*/
class PlatesBetweenCandles {
    fun platesBetweenCandles(s: String, queries: Array<IntArray>): IntArray {
        val candles = mutableListOf<Int>()
        // Step 1: Collect all candle positions
        for (i in s.indices) {
            if (s[i] == '|') {
                candles.add(i)
            }
        }

        val res = mutableListOf<Int>()
//       Process each query
        for ((qLeft, qRight) in queries) {
            var leftPos = -1
            var rightPos = -1

//            find the index of first candle
            var left = 0
            var right = candles.size - 1
            while (left <= right) {
                val mid = (left + right) / 2
                if (candles[mid] >= qLeft) {
                    right = mid - 1
                    leftPos = mid
                } else {
                    left = mid + 1
                }
            }
//            find the index of last candle
            left = 0
            right = candles.size - 1
            while (left <= right) {
                val mid = (left + right) / 2
                if (candles[mid] <= qRight) {
                    left = mid + 1
                    rightPos = mid
                } else {
                    right = mid - 1
                }
            }

//            calculate plates between candles
//            PlateBetween = (Distance Between the Two Candles) − (Number of Candles Between Them)
            if (leftPos != -1 && rightPos != -1 && rightPos > leftPos) {
                val platesBetween = (candles[rightPos] - candles[leftPos]) - (rightPos - leftPos)
                res.add(platesBetween)
            } else {
                res.add(0)
            }
        }
        return res.toIntArray()
    }
}

fun main() {
    val obj = PlatesBetweenCandles()
//    val s = "||***||**|*"
//    val res = obj.platesBetweenCandles(s, arrayOf(intArrayOf(2,8), intArrayOf(0,4), intArrayOf(3,7)))
    val s = "**|**|***|"
    val res = obj.platesBetweenCandles(s, arrayOf(intArrayOf(2,5), intArrayOf(5,9)))
    println(res.joinToString())
}
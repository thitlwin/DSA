package binary_search.leet875_koko_eating_bananas

import kotlin.math.ceil

class KoKoEatingBananas {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var l = 1
        var r = piles.sum()//1_000_000_000
        var ans = -1;
        while (l <= r) {
            val mid = l + (r - l)/2
            if(feasible(piles, h, mid)) {
                ans = mid;
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return ans
    }

    private fun feasible(piles: IntArray, h: Int, k: Int): Boolean {
        var numberOfUsedHour = 0.0
        piles.forEach {
            numberOfUsedHour += (it + k - 1) / k
        }
        return numberOfUsedHour <= h
    }
}

fun main() {
    val obj = KoKoEatingBananas()
    println(obj.minEatingSpeed(intArrayOf(3,6,7,11), 8))
//    println(obj.minEatingSpeed(intArrayOf(1000000000), 2))
//    println(obj.minEatingSpeed(intArrayOf(805306368,805306368,805306368), 1000000000))

//    println(
//        obj.minEatingSpeed(
//            intArrayOf(
//                332484035,
//                524908576,
//                855865114,
//                632922376,
//                222257295,
//                690155293,
//                112677673,
//                679580077,
//                337406589,
//                290818316,
//                877337160,
//                901728858,
//                679284947,
//                688210097,
//                692137887,
//                718203285,
//                629455728,
//                941802184
//            ), 823855818
//        ));

}
package leetcode_problem_1921
// This solution does not pass all the test cases.
class EliminateMaxNoOfMonster {
    var isFullyCharged = true
    var eliminatedCount = 0
    val chargingTime = 1

    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
        for (i in dist.indices) {
            if (isFullyCharged)
            {
                eliminatedCount++
                isFullyCharged = false
                continue
            }
            val timeToReachCity = dist[i] / speed[i]
            if (timeToReachCity > chargingTime) {
                eliminatedCount++
                continue
            }
            return eliminatedCount
        }
        return eliminatedCount
    }
}

fun main() {
    val obj = EliminateMaxNoOfMonster()
    val dist = intArrayOf(4,2,8)
    val speed = intArrayOf(2,1,4)
    println(obj.eliminateMaximum(dist, speed))
}
package leetcode_problem_2849

import kotlin.math.abs

class IsReachableCell {
    fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean {
        val xDist = abs(fx - sx)
        val yDist = abs(fy - sy)
        if (xDist == 0 && yDist ==0 && t == 1)
            return false
        return t >= xDist && t >= yDist
    }
}

fun main() {
    val obj = IsReachableCell()
    println(obj.isReachableAtTime(1,4,1,2,1))
}
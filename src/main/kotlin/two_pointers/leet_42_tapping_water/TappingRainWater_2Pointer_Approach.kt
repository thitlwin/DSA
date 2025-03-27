package two_pointers.leet_42_tapping_water

class TappingRainWater_2Pointer_Approach {
    fun trap(height: IntArray): Int {
        if (height.isEmpty()) return 0

        var left = 0
        var right = height.size - 1
        var leftMax = 0
        var rightMax = 0
        var totalWater = 0

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]
                } else {
                    totalWater += leftMax - height[left]
                }
                left++
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]
                } else {
                    totalWater += rightMax - height[right]
                }
                right--
            }
        }
        return totalWater
    }
}

fun main() {
    val obj = TappingRainWater_2Pointer_Approach()
//    println(obj.trap(intArrayOf(4,2,0,3,2,5)))
//    println(obj.trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
    println(obj.trap(intArrayOf(0,2,0,2,2,0)))

}
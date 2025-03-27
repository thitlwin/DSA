package two_pointers.leet_11_container_with_most_water

class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var maxArea = 0
        while(left < right) {
            val leftHeight = height[left]
            val rightHeight = height[right]
            val area = minOf(leftHeight, rightHeight) * (right - left)
            if(area > maxArea) {
                maxArea = area
            }
            if(leftHeight < rightHeight) {
                left++
            } else {
                right--
            }
        }
        return maxArea
    }
}
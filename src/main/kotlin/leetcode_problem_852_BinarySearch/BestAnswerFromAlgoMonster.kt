package leetcode_problem_852_BinarySearch

class BestAnswerFromAlgoMonster {
    fun peakOfMountainArray(arr: List<Int>): Int {
        var left = 0
        var right = arr.size - 1
        var boundaryIndex = -1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (mid == arr.size - 1 || arr[mid] > arr[mid + 1]) {
                boundaryIndex = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return boundaryIndex
    }
}
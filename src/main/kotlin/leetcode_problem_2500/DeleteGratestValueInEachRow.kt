package leetcode_problem_2500

class DeleteGratestValueInEachRow {
    fun deleteGreatestValue(grid: Array<IntArray>): Int {
        var result = 0
        for(arr in grid) {
            arr.sort()
        }

        for(i in 0 until grid[0].size) {
            var max = 0
            for(arr in grid) {
                if(arr[i] > max)
                    max = arr[i]
            }
            result += max
        }
        return result
    }
}
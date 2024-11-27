package binary_search

class NewspaperDistribution2 {
    fun distribute(list: List<Int>, numberOfWorkers: Int): Int {
        var low = list.max()
        var high = list.sum()
        var ans = -1
        while (low <= high) {
            val mid = low + (high - low)/2
            if (feasible(mid, list, numberOfWorkers)) {
                ans = mid
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return ans
    }

    private fun feasible(mid: Int, newsPapers: List<Int>, numberOfWorkers: Int): Boolean {
        var currentWorker = 1
        var currentWorkerReadingTime = 0
        newsPapers.forEach {
            if(it + currentWorkerReadingTime > mid){
                currentWorker++
                currentWorkerReadingTime = 0
            }
            currentWorkerReadingTime += it
        }
        return currentWorker <= numberOfWorkers
    }
}

fun main() {
    val obj = NewspaperDistribution2()
    println(obj.distribute(listOf(1,3,5,7,9,2,4,6), 4))
    println(obj.distribute(listOf(2,3,5,7), 3))
    println(obj.distribute(listOf(7,2,5,10,8), 2))
}
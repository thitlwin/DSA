package search.binary_search

/*
*
* You've begun your new job to organize newspapers. Each morning, you are to separate the newspapers into smaller piles and assign each pile to a co-worker. This way, your co-workers can read through the newspapers and examine its contents simultaneously.

Each newspaper is marked with a read time to finish all its contents. A worker can read one newspaper at a time, and when they finish a newspaper, they can start reading the next newspaper. Your goal is to minimize the amount of time needed for your co-workers to finish all newspapers. Additionally, the newspapers came in a particular order, and you must not disarrange the original ordering when distributing the newspapers. In other words, you cannot pick and choose newspapers randomly from the whole pile to assign to a co-worker, but rather you must take a subsection of consecutive newspapers from the whole pile.

What is the minimum amount of time it would take to have your coworkers go through all the newspapers? That is, if you optimize the distribution of newspapers, what is the longest read time among all piles?

Constraints
1 <= newspapers_read_times.length <= 10^5

1 <= newspapers_read_times[i] <= 10^5

1 <= num_coworkers <= 10^5

Examples
Example 1:
Input: newspapers_read_times = [7,2,5,10,8], num_coworkers = 2
Output: 18
Explanation:
Assign first 3 newspapers to one coworker then assign the rest to another. The time it takes for the first 3 newspapers is 7 + 2 + 5 = 14 and for the last 2 is 10 + 8 = 18.

Example 2:
Input: newspapers_read_times = [2,3,5,7], num_coworkers = 3
Output: 7
Explanation:
Assign [2, 3], [5], and [7] separately to workers. The minimum time is 7.
* */
class NewsPaperDistribution {
    fun newspapersSplit(newspaperReadTimes: List<Int>, numCoworkers: Int): Int {
        var low = newspaperReadTimes.max()
        var high = 0
        var ans = -1
        for (readTime in newspaperReadTimes) {
            high += readTime
            while (low <= high) {
                val mid = (high + low) / 2
                if (feasible(newspaperReadTimes, numCoworkers, mid)) {
                    ans = mid
                    high = mid - 1
                } else {
                    low = mid + 1
                }
            }
        }
        return ans
    }

    private fun feasible(newspaperReadTimes: List<Int>, numCoworkers: Int, mid: Int): Boolean {
        var currentWorkerTime = 0
        var numberOfWorker = 0
        for (readTime in newspaperReadTimes) {
            if (readTime + currentWorkerTime > mid) {
                currentWorkerTime = 0
                numberOfWorker++
            }
            currentWorkerTime += readTime
        }
        if (currentWorkerTime != 0) {
            numberOfWorker++
        }
        return numberOfWorker <= numCoworkers
    }
}

fun main() {
    val obj = NewsPaperDistribution()
//    val res = obj.newspapersSplit(listOf(7, 2, 5, 10, 8), 2) // 18
//    val res = obj.newspapersSplit(listOf(1,4,4), 3) // 4

//    val res = obj.newspapersSplit(
//        listOf(
//            2873,
//            2837,
//            10,
//            3,
//            12,
//            34,
//            21,
//            450,
//            12,
//            4,
//            39,
//            1,
//            40,
//            59,
//            2,
//            67,
//            93,
//            49,
//            837,
//            499,
//            237,
//            287,
//            459,
//            12309,
//            9249,
//            94878,
//            30
//        ), 4
//    ) // 94878
//    val res = obj.newspapersSplit(listOf(1,1,1,1,1,1), 1) // 6
//    val res = obj.newspapersSplit(listOf(15,15,15,15), 4) // 15
    val res = obj.newspapersSplit(listOf(1,2,4,7,8), 2) // 6
    println(res)
}
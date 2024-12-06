package binary_search.leet1146_snapshop_array

class SnapshotArray1(length: Int) {
    private val histories: MutableList<MutableList<Pair<Int, Int>>> = MutableList(length) { mutableListOf(Pair(-1, 0)) }
    private var snapId: Int = 0

    // Set a value at a specific index
    fun set(index: Int, value: Int) {
        histories[index].add(Pair(snapId, value))
    }

    // Take a snapshot and return the snap_id
    fun snap(): Int {
        return snapId++
    }

    // Get the value at a specific index and snapshot
    fun get(index: Int, snapId: Int): Int {
        val history = histories[index]
        var left = 0
        var right = history.size - 1
        var pos = -1

        // Binary search for the closest snap_id less than or equal to the given snapId
        while (left <= right) {
            val mid = (left + right) / 2
            if (history[mid].first <= snapId) {
                pos = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return history[pos].second
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * var obj = SnapshotArray(length)
 * obj.set(index,`val`)
 * var param_2 = obj.snap()
 * var param_3 = obj.get(index,snap_id)
 */
package binary_search.leet1146_snapshop_array

//TC
//O(1)ForSet, O(Log(S))ForSnap(), O(Log(S))ForGet,
//Where S Is TheMaximumNumberOfSnapshots Stored For Any Element
//
//SC
//O(N)ForStoringTheHistoriesList,
//Where N Is TheLengthOfTheArray
class SnapshotArray(length: Int) {
    private var histories: Array<ArrayList<Pair<Int, Int>>> = Array(length) { arrayListOf(Pair(-1, 0)) }

    private var snapId: Int = 0

    fun set(index: Int, `val`: Int) {
        histories[index].add(Pair(snapId, `val`))
    }

    fun snap(): Int {
        return snapId++
    }

    fun get(index: Int, snap_id: Int): Int {
        val history = histories[index]
        var left = 0
        var right = history.size - 1
        var pos = -1
        while (left <= right ) {
            val mid = left + (right - left) / 2
            if (history[mid].first <= snap_id) {
                pos = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return history[pos].second
    }

}

fun main() {
//    [[1],[0,4],[0,16],[0,13],[],[0,0],[]]
//    val obj = SnapshotArray(1)
//    obj.set(0, 4)
//    obj.set(0, 16)
//    obj.set(0, 13)
//    obj.snap()
//    println(obj.get(0,0))
//    obj.snap()
//    [[2],[],[1,17],[0,20],[],[],[]]

//    val obj = SnapshotArray(2)
//    obj.run {
//        snap()
//        set(1,17)
//        set(0,20)
//        snap()
//        snap()
//        snap()
//    }

//    [[4],[],[],[3,1],[2,4],[],[1,4]]
//    val obj = SnapshotArray(4)
//    obj.run {
//        snap()
//        snap()
//        get(3,1)
//        set(2,4)
//        snap()
//        set(1,4)
//    }

//    [[1],[0,15],[],[],[],[0,2],[],[],[0,0]]
//    ["SnapshotArray","set","snap","snap","snap","get","snap","snap","get"]
    val obj = SnapshotArray(1)
    obj.run {
        set(0,15)
        snap()
        snap()
        snap()
        println(get(0,2))
        snap()
        snap()
        println(get(0,0))
    }
}
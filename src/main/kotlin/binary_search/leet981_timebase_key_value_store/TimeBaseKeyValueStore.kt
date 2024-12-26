package binary_search.leet981_timebase_key_value_store

class TimeBaseKeyValueStore {
    val histories = mutableMapOf<String, ArrayList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        val history = histories.getOrDefault(key, arrayListOf())
        history.add(Pair(timestamp, value))
        histories[key] = history
    }

    fun get(key: String, timestamp: Int): String {
        val prevList = histories.getOrDefault(key, emptyList())
        val lastItem = getLastItem(prevList, key, timestamp)
        return lastItem
    }

    private fun getLastItem(prevList: List<Pair<Int, String>>, key: String, timestamp: Int): String {
        if (prevList.isEmpty()) return ""
        var left = 0
        var right = prevList.size - 1
        var pos = -1
        while (left <= right) {
            val mid = left + (right-left) / 2
            if (prevList[mid].first <= timestamp) {
                pos = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        if (pos == -1) return ""
        return prevList[pos].second
    }
}

fun main() {
    val obj = TimeBaseKeyValueStore()
//    [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
    obj.set("love", "high", 10)
    obj.set("love", "low", 20)
    println(obj.get("love", 5)) // return "" (there is not value before 10)
    println(obj.get("love", 10))
    println(obj.get("love", 15))
    println(obj.get("love", 20))
    println(obj.get("love", 25))

//    [[],["a","bar",1],["x","b",3],["b",3],["foo","bar2",4],["foo",4],["foo",5]]
}
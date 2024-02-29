package disjoint_union_set

class SameSet {
//    private val dsu = UnionFind<Int>()
    private val dsu = UnionFindByRank<Int>()
    fun merge(x: Int, y: Int) {
        dsu.union(x, y)
    }

    fun isSame(x: Int, y: Int): Boolean {
        return dsu.find(x) == dsu.find(y)
    }
}

fun main() {
    val obj = SameSet()
    obj.merge(1, 2)
    obj.merge(2, 3)
    println(obj.isSame(1, 3))
    println(obj.isSame(1, 4))
}
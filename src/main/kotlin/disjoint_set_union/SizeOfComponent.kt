package disjoint_set_union

class SizeOfComponent {
    private val sizes = HashMap<Int, Int>()
    private val dsu = UnionFind<Int>()
    fun merge(x: Int, y: Int){
        if (dsu.find(x) != dsu.find(y)){
            val newSize = count(x) + count(y)
            dsu.union(x, y)
            sizes[dsu.find(x)] = newSize
        }
    }

    fun count(x: Int): Int {
        return sizes.getOrDefault(dsu.find(x), 1)
    }
}

fun main() {
    val obj = SizeOfComponent()
    obj.merge(1,2)
    obj.merge(2,3)
    println(obj.count(3))
//    println(obj.count(1))
//    println(obj.count(1))
//    println(obj.count(2))
}
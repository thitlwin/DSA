package disjoint_union_set

class UnionFind<T> {
    private val id = HashMap<T, T>()
    fun find(x: T): T{
        var y = id.getOrDefault(x, x)
        if (y != x){
            y = find(y)
            id[x] = y
        }
        return y
    }

    fun union(x: T, y: T){
        id[find(x)] = find(y)
    }
}
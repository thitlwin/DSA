package disjoint_union_set

class UnionFindByRank<T> {
    val id = HashMap<T,T>()
    val rank = HashMap<T, Int>()
    fun find(x: T): T {
        var y = id.getOrDefault(x,x)
        if (y!=x){
            y = find(y)
           id[x] = y
        }
        return y
    }

    fun union(x:T,y:T){
        if (!rank.containsKey(find(x))) rank[find(x)] = 0
        if (!rank.containsKey(find(y))) rank[find(y)] = 0
        if (rank[find(x)]!! < rank[find(y)]!!){
            id[find(x)] = find(y)
        } else {
            id[find(y)] = find(x)
            if (rank[find(x)] == rank[find(y)])
                rank[find(x)] = rank[find(x)]!! + 1
        }
    }
}
package binary_search_tree
data class Node<T> (val `val`: T) {
    var left: Node<T>? = null
    var right: Node<T>? = null
}
class IsBinarySearchTree {

    fun validBst(node: Node<Int>?): Boolean {
        return dfs(node, min = Integer.MIN_VALUE, max = Integer.MAX_VALUE)
    }

    private fun dfs(node: Node<Int>?, min: Int, max: Int): Boolean {
        if(node == null) return true
        if (node.`val` !in (min + 1) until max) {
            return false
        }
        return dfs(node.left, min, node.`val`) && dfs(node.right, node.`val`, max)
    }
}

fun main() {
    val obj = IsBinarySearchTree()
    val node7 = Node(7)
    val node6 = Node(6)
    val node5 = Node(5)
    val node4 = Node(4)
    val node3 = Node(3)
    val node2 = Node(2)
    val node1 = Node(1)

//    val node6 = Node(6).apply {
//        left = node4
//        right = node7
//    }
//    node4.apply {
//        left = node3
//        right = node5
//    }
//    println(obj.validBst(node6)) // true

//    node6.apply {
//        left = node5
//    }
//    node5.apply {
//        right = node4
//    }
//    println(obj.validBst(node6)) // false

//    node1.apply {
//        left = node2
//        right = node3
//    }
//    println(obj.validBst(node1)) // false

    node2.apply {
        left = node1
        right = node3
    }
    println(obj.validBst(node2)) // true
}
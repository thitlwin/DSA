package dfs.visible_node

data class Node<T>(
    val `val`: T,
    var left: Node<T>?,
    var right: Node<T>?
)
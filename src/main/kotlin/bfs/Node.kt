package bfs

data class Node<T>(val `val`: T) {
    var left: Node<T>? = null
    var right: Node<T>? = null
}
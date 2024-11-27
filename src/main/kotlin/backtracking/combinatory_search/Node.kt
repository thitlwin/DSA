package backtracking.combinatory_search

data class Node<T>(val `val`: T) {
    val children: MutableList<Node<T>> = mutableListOf()
}
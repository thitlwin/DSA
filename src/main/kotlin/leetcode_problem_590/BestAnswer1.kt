package leetcode_problem_590

import leetcode_problem_589.NaryTreePreorderTraversal

class BestAnswer1 {
    fun postorder(root: Node?): List<Int> {
        return root?.let {
            it.children.flatMap { child -> postorder(child) } + listOf(it.`val`)
        } ?: emptyList()
    }
}

fun main() {
    val root = Node(1)
    val _3 = Node(3)
    root.children = mutableListOf(_3, Node(2), Node(4))
    _3.children = mutableListOf(Node(5), Node(6))

    val objects = BestAnswer1()
    println(objects.postorder(root))
}
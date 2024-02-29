package leetcode_problem_589

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}

class NaryTreePreorderTraversal {
    val result = mutableListOf<Int>()
    fun preorder(root: Node?): List<Int> {
        if (root == null) return result
        result.add(root.`val`)
        val reversedChildren = root.children.reversed().toMutableList()

        while (reversedChildren.isNotEmpty()) {
            val node = reversedChildren.removeLast()
            preorder(node)
        }
        return result
    }
}

fun main() {
    val root = Node(1)
    val _3 = Node(3)
    root.children = mutableListOf(_3, Node(2), Node(4))
    _3.children = mutableListOf(Node(5), Node(6))

    val objects = NaryTreePreorderTraversal()
    println(objects.preorder(root))
}
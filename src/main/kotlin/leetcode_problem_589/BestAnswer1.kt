package leetcode_problem_589

class BestAnswer1 {
    fun preorder(root: Node?): List<Int> {
        val result = mutableListOf<Int>()
        traversePreOrder(root, result)
        return result
    }

    private fun traversePreOrder(root: Node?, result: MutableList<Int>) {
        if (root == null) return
        result.add(root.`val`)
        root.children.forEach {
            traversePreOrder(it, result)
        }
    }
}

fun main() {
    val root = Node(1)
    val _3 = Node(3)
    root.children = mutableListOf(_3, Node(2), Node(4))
    _3.children = mutableListOf(Node(5), Node(6))

    val objects = BestAnswer1()
    println(objects.preorder(root))
}
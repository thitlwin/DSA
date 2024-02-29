package leetcode_problem_590


class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}

class NaryTreePostorderTraversal {
    val result = mutableListOf<Int>()
    fun postorder(root: Node?): List<Int> {
        if(root == null) return result
        root.children.forEach {
            postorder(it)
        }
        result.add(root.`val`)
        return result
    }
}
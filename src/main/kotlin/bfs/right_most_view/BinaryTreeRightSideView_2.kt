package bfs.right_most_view

data class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
class BinaryTreeRightSideView_2 {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result: ArrayList<Int> = arrayListOf()
        root ?: return result
        val queue:ArrayDeque<TreeNode?> = ArrayDeque()
        queue.add(root)

        while(queue.isNotEmpty()) {
            val rightMost = queue.first()
            result.add(rightMost!!.`val`)
            val n = queue.size
            for(i in 0 until n) {
                val node = queue.removeFirst()
                node?.right?.let{
                    queue.add(it)
                }
                node?.left?.let {
                    queue.add(it)
                }
            }
        }
        return result
    }
}


fun main() {
    val root = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    val node4 = TreeNode(4)
    val node5 = TreeNode(5)
    val node6 = TreeNode(6)
    val node7 = TreeNode(7)
    root.apply {
        left = node2
        right = node3
    }
    node2.apply {
        left = node4
        right = node5
    }
    node3.apply {
        left = node6
    }
    node4.apply {
        left = node7
    }

    val obj = BinaryTreeRightSideView_2()
    val res = obj.rightSideView(root)
    println(res)
}
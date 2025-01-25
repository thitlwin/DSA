package bfs.right_most_view

class BinaryTreeRightSideView_FirstAnswer {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result: ArrayList<Int> = arrayListOf()

        fun bfs(root: TreeNode?, level: Int) {
            root ?: return
            if (result.size == level) {
                result.add(root.`val`)
            }
            bfs(root.right, level + 1)
            bfs(root.left, level + 1)
        }
        bfs(root, 0)
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

    val obj = BinaryTreeRightSideView_FirstAnswer()
    val res = obj.rightSideView(root)
    println(res)
}
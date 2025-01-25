package bfs.min_depth

data class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class MinDepth_2_BFS_Approach {
    fun minDepth(root: TreeNode?): Int {
        val queue: ArrayDeque<TreeNode?> = ArrayDeque()
        root ?: return 0
        queue.add(root)
        var depth = 0
        while (queue.isNotEmpty()) {
            val n = queue.size
            depth++
            for (i in 0 until n) {
                val node = queue.removeFirst()
                if (node!!.left == null && node.right == null) {
                    return depth
                }
                node.left?.let {
                    queue.add(it)
                }
                node.right?.let {
                    queue.add(it)
                }
            }
        }
        return depth
    }
}

fun main() {
    val obj = MinDepth_2_BFS_Approach()
    val root = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(5)
        }
        right = TreeNode(3)
    }
    val res = obj.minDepth(root)
    println(res)
}
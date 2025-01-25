package bfs.min_depth
//fun minDepth(root: TreeNode?): Int {
//        root ?: return 0
//        if(root.left == null)
//            return 1 + minDepth(root.right)
//        if(root.right == null)
//            return 1 + minDepth(root.left)
//        return minOf(minDepth(root.left), minDepth(root.right)) + 1
//    }
class MinDepth_2_DFS {
    fun minDepth(root: TreeNode?): Int {
        root ?: return 0
        if(root.left == null) {
            return minDepth(root.right) + 1
        }
        if (root.right == null)
            return minDepth(root.left) + 1
        return minOf(minDepth(root.left), minDepth(root.right)) + 1
    }
}

fun main() {
    val obj = MinDepth_2_DFS()
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
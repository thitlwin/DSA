package bfs
data class TreeNode(val`val`: Int){
    var left: TreeNode? = null
    var right: TreeNode? = null
}
//This is my own problem
class ShallowestLeafNode {
    fun minDepth(root: TreeNode?): Int {
        val queue: ArrayDeque<TreeNode?> = ArrayDeque()
        root ?: return Int.MIN_VALUE

        queue.addFirst(root)
        while(queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if(node!!.left == null && node.right == null) {
                return node.`val`
            }
            node.left?.let{
                queue.add(it)
            }
            node.right?.let{
                queue.add(it)
            }
        }
        return Int.MIN_VALUE
    }
}

fun main() {
    val obj = ShallowestLeafNode()
//    val root = TreeNode(3).apply {
//        left = TreeNode(9)
//        right = TreeNode(20).apply {
//            left = TreeNode(15)
//            right = TreeNode(7)
//        }
//    }
    val root = TreeNode(2).apply {
        right = TreeNode(3).apply {
            left = TreeNode(1)
            right = TreeNode(9).apply {
                right = TreeNode(5).apply {
                    right = TreeNode(6)
                }
            }
        }
    }
    val res = obj.minDepth(root)
    println(res)
}
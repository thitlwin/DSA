import leetcode_problem_111_min_tree_depth.TreeNode

data class BTreeNode(val `val`: Int){
    var left: BTreeNode? = null
    var right: BTreeNode? = null
}
class BottomLeftMostTreeNode {
    fun bottomLeftMostNode(root: BTreeNode?): Int {
        root ?: return -1
        val queue = ArrayDeque<BTreeNode>()
        queue.add(root)
        var level = 0
        val hm = HashMap<Int, List<BTreeNode>>()
        hm[0] = listOf(root)
        while (queue.isNotEmpty()) {
            level++
            val node = queue.removeFirst()
            val children = mutableListOf<BTreeNode>()
            node.left?.let {
                children.add(it)
                queue.add(it)
                hm[level] = children
            }
            node.right?.let {
                children.add(it)
                queue.add(it)
                hm[level] = children
            }
        }
        return hm[level]?.get(0)?.`val` ?: -1
    }
}

fun main() {
    val obj = BottomLeftMostTreeNode()
    val node1 = BTreeNode(1).apply {
        left = BTreeNode(2)
        right = BTreeNode(3)
    }
    println(obj.bottomLeftMostNode(node1))
}
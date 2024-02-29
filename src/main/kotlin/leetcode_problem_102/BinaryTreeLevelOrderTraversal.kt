package leetcode_problem_102

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BinaryTreeLevelOrderTraversal {
    val resultList = mutableListOf<List<Int>>()

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return listOf()

        val queue = ArrayDeque<List<TreeNode>?>()
        queue.add(listOf(root))

        resultList.add(listOf(root.`val`))
        var nodesInQueue = queue.removeFirst()

        while (nodesInQueue != null) {

            val childList = mutableListOf<Int>()
            val childNodeList = mutableListOf<TreeNode>()
            nodesInQueue.forEach { node ->
                node.left?.let { left ->
                    childList.add(left.`val`)
                    childNodeList.add(left)
                }
                node.right?.let { right ->
                    childList.add(right.`val`)
                    childNodeList.add(right)
                }
            }

            if (childList.size > 0) {
                resultList.add(childList)
                queue.add(childNodeList)
            }
            nodesInQueue = queue.removeFirstOrNull()
        }
        return resultList
    }
}

fun main() {
    val p = TreeNode(1)
    val two = TreeNode(2)
    val three = TreeNode(3)
    val four = TreeNode(4)
    val five = TreeNode(5)

    p.left = two
    p.right = three

    three.right = five
    two.left = four

    val levelOrderTraversal = BinaryTreeLevelOrderTraversal()
    println(levelOrderTraversal.levelOrder(p))
}
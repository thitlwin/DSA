package leetcode_problem_102

import java.util.*

class BinaryTreeLevelOrderTraversalWithLinkedListQueue {
    val resultList = mutableListOf<List<Int>>()

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return listOf()

        val queue: Queue<List<TreeNode>?> = LinkedList<List<TreeNode>?>()
        queue.add(listOf(root))
        resultList.add(listOf(root.`val`))

        var nodesInQueue = queue.poll()
        while (nodesInQueue != null) {

            val childList = mutableListOf<Int>()
            val childNodeList = mutableListOf<TreeNode>()
            nodesInQueue.forEach {
                it.left?.let { left ->
                    childList.add(left.`val`)
                    childNodeList.add(left)
                }
                it.right?.let { right ->
                    childList.add(right.`val`)
                    childNodeList.add(right)
                }
            }

            if (childList.size > 0) {
                resultList.add(childList)
                queue.add(childNodeList)
            }
            nodesInQueue = queue.poll()
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
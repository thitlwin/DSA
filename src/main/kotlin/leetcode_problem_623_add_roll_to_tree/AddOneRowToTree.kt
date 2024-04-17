package leetcode_problem_623_add_roll_to_tree

import java.util.LinkedList
import kotlin.math.pow

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class AddOneRowToTree {
    fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
        if (depth == 1) {
            val node = TreeNode(`val`)
            node.left = root
            return node
        }
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        var currentDepth = 1

        while (currentDepth < depth - 1){
            for (i in 0 until queue.size) {
                val node = queue.poll()
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
            currentDepth++
        }

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            val leftChild = TreeNode(`val`)
            val rightChild = TreeNode(`val`)
            leftChild.left = node.left
            rightChild.right = node.right

            node.left = leftChild
            node.right = rightChild
        }
        return root
    }
}

fun main() {
    val obj = AddOneRowToTree()
//    val root = TreeNode(4).apply {
//        left = TreeNode(2).apply {
//            left = TreeNode(3)
//            right = TreeNode(1)
//        }
//        right = TreeNode(6).apply {
//            left = TreeNode(5)
//        }
//    }
//    val res = obj.addOneRow(root, 1, 2)

    val root = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4).apply {
                left = TreeNode(5)
                right = TreeNode(5)
            }
        }
        right = TreeNode(3)
    }
    val res = obj.addOneRow(root, 5, 4)
    print(res?.right)
}
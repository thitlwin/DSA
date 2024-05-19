package leetcode_problem_1325_DeleteLeafWithGivenValue

import java.util.Stack

class DeleteLeafWithGivenValue_Iterative {
    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        val stack = Stack<TreeNode>()
        var current = root
        var lastRightNode: TreeNode? = null
        while (!stack.isEmpty() || current != null) {
            // push left node to the stack until reaching the leftmost node
            while (current != null) {
                stack.push(current)
                current = current.left
            }

            // access the top node on the stack without removing it
            // this node is the current candidate for processing
            current = stack.peek()

            // check if the current node has an unexplored right subtree.
            // If so, shift to the right subtree unless it's the subtree we just visited
            if (current.right != lastRightNode &&
                current.right != null
            ) {
                current = current.right
                continue
            }

            // remove the node from the stack, since we're about to process it
            stack.pop()

            // if the node has no right subtree or the right subtree has already been visited,
            // then check if it is a leaf node with the target value.
            if (current.right == null &&
                current.left == null &&
                current.`val` == target
            ) {
                if (stack.isEmpty()) {
                    return null
                }

                val parent = if (stack.isEmpty()) null else stack.peek()
                if (parent != null) {
                    if (parent.left == current) {
                        parent.left = null
                    } else {
                        parent.right = null
                    }
                }
            }
            lastRightNode = current
            current = null
        }
        return root
    }
}

fun main() {
    val obj = DeleteLeafWithGivenValue_Iterative()
    val n1 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(2)
        }
        right = TreeNode(3).apply {
            left = TreeNode(2)
            right = TreeNode(4)
        }
    }
    val res = obj.removeLeafNodes(n1, 2)
    println(res)
}
package leetcode_problem_543_dfs_tree_diameter

import kotlin.math.max

class TreeHeight {
    fun maxHeight(root: TreeNode?): Int {
        root?:return 0
        return dfs(root)
    }

    private fun dfs(node: TreeNode?): Int {
        node?: return 0
        return max(dfs(node.left), dfs(node.right)) + 1
    }
}

fun main() {
    val obj = TreeHeight()
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    val node4 = TreeNode(4)
    val node5 = TreeNode(5)
    val node6 = TreeNode(6)
    val node7 = TreeNode(7)
    val node8 = TreeNode(8)
    val node9 = TreeNode(9)
    val node10 = TreeNode(10)

    val node11 = TreeNode(11)

    node1.apply {
        left = node2.apply {
            left = node4
            right = node5
        }
        right = node3
    }

//    node1.apply {
//        left = node2.apply {
//            left = node4.apply {
//                left = node6
//                right = node7
//            }
//            right = node5.apply {
//                left = node8.apply { left = node10 }
//                right = node9
//            }
//        }
//        right = node3
//    }
    println(obj.maxHeight(node1))
}
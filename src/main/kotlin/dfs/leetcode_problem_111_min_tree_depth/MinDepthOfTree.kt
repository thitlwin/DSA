package dfs.leetcode_problem_111_min_tree_depth

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class MinDepthOfTree {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        if (root.left == null) {
            return 1 + minDepth(root.right)
        }
        if (root.right == null)
            return 1 + minDepth(root.left)
        return 1 + minOf(minDepth(root.left), minDepth(root.right))
    }
}

fun main() {
//    val one = TreeNode(1)
//    val two = TreeNode(2)
//    val three = TreeNode(3)
//    val four = TreeNode(4)
//    val five = TreeNode(5)
//    val six = TreeNode(6)
//    val seven = TreeNode(7)
//
//    one.left = two
//    one.right = three
//
//    two.left = four
//    three.right = five
//
//    four.left = six
//    five.right = seven

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

    val mindepth = MinDepthOfTree()
    // balanced tree
//    node1.apply {
//        left = node2.apply {
//            left = node4
//            right = node5
//        }
//        right = node3.apply {
//            left = node6
//            right = node7
//        }
//    }

//    unbalanced tree
//    node1.apply {
//        right = node2.apply {
//            left = node3
//            right = node4.apply {
//                right = node5.apply {
//                    right = node6
//                }
//            }
//        }
//    }
    // skewed tree
    node7.apply { right = node8.apply { right = node9.apply { right = node10 } } }
    println(mindepth.minDepth(node7))
}
package leetcode_problem_531_leftMostValue

import dfs.leetcode_problem_111_min_tree_depth.TreeNode

class LeftMostValue_BFS {
    fun findBottomLeftValue(root: TreeNode?): Int {
        root ?: return -1
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        var leftMostValue = -1
        while(queue.isNotEmpty()){
            leftMostValue = queue.first().`val`
            for(i in queue.size downTo  1){
                val node = queue.removeFirst()
                node.run{
                    left?.let{
                        queue.add(it)
                    }
                    right?.let{
                        queue.add(it)
                    }
                }
            }
        }
        return leftMostValue
    }
}

fun main() {
    val obj = LeftMostValue_BFS()
    val one = TreeNode(1)
    val two = TreeNode(2)
    val three = TreeNode(3)
    val four = TreeNode(4)
    val five = TreeNode(5)
    val six = TreeNode(6)
    val seven = TreeNode(7)

    one.left = two
    one.right = three

    two.left = four
    three.right = five

    four.left = six
    five.right = seven
    println(obj.findBottomLeftValue(one))
}
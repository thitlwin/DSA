package leetcode_problem_1609_even_odd_tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class EvenOddTree {
    fun isEvenOddTree(root: TreeNode?): Boolean {
        root ?: return false
        if (root.`val` % 2 == 0)
            return false
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        var level = 1
        while (queue.isNotEmpty()) {
            val isEvenLevel = level % 2 == 0
            var minValue = -Int.MAX_VALUE
            var maxValue = Int.MAX_VALUE

            for (i in queue.size downTo 1) {
                val node = queue.removeFirst()

                if (isEvenLevel) {
                    node.left?.let {
                        if (it.`val` % 2 == 0) return false
                        if (it.`val` <= minValue) return false
                        minValue = it.`val`
                        queue.add(it)
                    }

                    node.right?.let {
                        if (it.`val` % 2 == 0) return false
                        if (it.`val` <= minValue) return false
                        minValue = it.`val`
                        queue.add(it)
                    }
                } else { // odd level
                    node.left?.let {
                        if (it.`val` % 2 != 0) return false
                        if (it.`val` >= maxValue) return false
                        maxValue = it.`val`
                        queue.add(it)
                    }

                    node.right?.let {
                        if (it.`val` % 2 != 0) return false
                        if (it.`val` >= maxValue) return false
                        maxValue = it.`val`
                        queue.add(it)
                    }
                }
            }
            level++
        }
        return true
    }
}

fun main() {
    val node1 = TreeNode(1).apply {
        left = TreeNode(10).apply {
            left = TreeNode(3).apply {
                left = TreeNode(12)
                right = TreeNode(8)
            }
        }

        right = TreeNode(4).apply {
            left = TreeNode(7).apply {
                left = TreeNode(6)
            }
            right = TreeNode(9).apply {
                right = TreeNode(2)
            }
        }
    }
//    val node1 = TreeNode(5).apply {
//        left = TreeNode(4).apply {
//            left = TreeNode(3)
//            right = TreeNode(3)
//        }
//        right = TreeNode(2).apply {
//            left = TreeNode(7)
//        }
//    }
    val obj = EvenOddTree()
    println(obj.isEvenOddTree(node1))
}
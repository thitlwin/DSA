package bfs

class MinDepth {
    fun binaryTreeMinDepth(root: Node<Int>): Int {
        var depth = -1
        val queue = ArrayDeque<Node<Int>>()
        queue.add(root)
        while (queue.size > 0){
            depth++
            val n = queue.size
            for(i in 0 until n) {
                val node = queue.removeFirst()
                if (node.left == null && node.right==null) {
                    return depth
                }
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
        }
        return depth
    }
}

fun main() {
    val root = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    val node5 = Node(5)
    val node6 = Node(6)
    val node7 = Node(7)
    root.apply {
        left = node2
        right = node3
    }
    node2.apply {
        left = node4
        right = node5
    }
    node3.apply {
        left = node6
    }
    node4.apply {
        left = node7
    }

    val obj = MinDepth()
    println(obj.binaryTreeMinDepth(root))
}
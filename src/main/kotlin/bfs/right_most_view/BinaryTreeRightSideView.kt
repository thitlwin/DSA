package bfs.right_most_view

import bfs.Node

class BinaryTreeRightSideView {
    fun binaryTreeRightSideView(root: Node<Int>): List<Int> {
        val res = ArrayList<Int>()
        val queue = ArrayDeque<Node<Int>>()
        queue.add(root)

        while (queue.size > 0) {
            val n = queue.size
            res.add(queue.first().`val`)
            for (i in 0 until n){
                val node = queue.removeFirst()
                node.right?.let{queue.add(it)}
                node.left?.let{queue.add(it)}
            }
        }
        return res
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

    val obj = BinaryTreeRightSideView()
    val res = obj.binaryTreeRightSideView(root)
    println(res)
}
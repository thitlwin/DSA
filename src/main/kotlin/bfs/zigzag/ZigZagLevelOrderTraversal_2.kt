package bfs.zigzag

import bfs.Node

class ZigZagLevelOrderTraversal_2 {
    fun zigZagTraversal(root: Node<Int>?): List<List<Int>> {
        val result: ArrayList<List<Int>> = arrayListOf()
        root?:return emptyList()
        val queue= ArrayDeque<Node<Int>>()
        queue.add(root)
        var leftToRight = true
        while (queue.isNotEmpty()) {
            val queueSize = queue.size
            val path: ArrayList<Int> = arrayListOf()
            for (i in 0 until queueSize) {
                val node = if (leftToRight) queue.removeFirst() else queue.removeLast()
                path.add(node.`val`)
                if (leftToRight)
                {
                    node.left?.run {
                        queue.addLast(this)
                    }
                    node.right?.run {
                        queue.addLast(this)
                    }
                } else {
                    node.right?.run {
                        queue.addFirst(this)
                    }
                    node.left?.run {
                        queue.addFirst(this)
                    }
                }
            }
            leftToRight = !leftToRight
            result.add(path)
        }
        return result
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

    val obj = ZigZagLevelOrderTraversal_2()
    val res = obj.zigZagTraversal(root)
    println(res)
}
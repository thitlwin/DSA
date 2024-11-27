package dfs

import java.util.StringJoiner

class SerializeDeserializeTree {
    fun serialize(node: Node<Int>): String {
        val res = StringJoiner(" ")
        serializeDFS(node, res)
        return res.toString()
    }

    private fun serializeDFS(node: Node<Int>?, res: StringJoiner) {
        if (node == null) {
            res.add("x")
            return
        }

        res.add(node.`val`.toString())
        serializeDFS(node.left, res)
        serializeDFS(node.right, res)
    }

    fun deserialize(str: String): Node<Int>? {
        return deserializeDFS(str.split(" ").iterator())
    }

    private fun deserializeDFS(nodes: Iterator<String>): Node<Int>? {
        val next = nodes.next()
        if (next == "x")
            return null
        val node = Node(next.toInt())
        node.left = deserializeDFS(nodes)
        node.right = deserializeDFS(nodes)
        return node
    }
}

fun main() {
    val obj = SerializeDeserializeTree()
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    val node5 = Node(5)
    val node6 = Node(6)
    val node7 = Node(7)

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

    node1.apply {
        left = node2.apply {
            left = node3
        }
        right = node4.apply {
            right = node5
        }
    }

    val res = obj.serialize(node1)
    println(res)
    val node = obj.deserialize(res)
    println(node)
}
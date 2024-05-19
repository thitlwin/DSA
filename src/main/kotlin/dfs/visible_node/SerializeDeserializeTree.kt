package dfs.visible_node

import dfs.Node
import java.util.StringJoiner

class SerializeDeserializeTree {
    fun serialize(root: Node<Int>?): String {
        val result = StringJoiner(" ")
        if (root == null) {
            return "x"
        }
        result.add(root.`val`.toString())
        result.add(serialize(root.left))
        result.add(serialize(root.right))
        return result.toString()
    }

    fun deserialize(input: String): Node<Int>?  {
        val iterator = input.split(" ").iterator()
        return deserializeDFS(iterator)
    }

    private fun deserializeDFS(iterator: Iterator<String>): Node<Int>? {
        val element = iterator.next()
        if (element == "x")
            return null
        val node = Node(element.toInt())
        node.left = deserializeDFS(iterator)
        node.right = deserializeDFS(iterator)
        return node
    }
}

fun main() {
    val obj = SerializeDeserializeTree()
    val node3 = Node(3)
    val node2 = Node(2)
    val node1 = Node(1)
    val serializedStr = obj.serialize(node1)
    println(serializedStr)
    val deserializeTree = obj.deserialize(serializedStr)
    println(deserializeTree)
}
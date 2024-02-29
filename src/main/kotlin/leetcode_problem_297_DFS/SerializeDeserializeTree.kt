package leetcode_problem_297_DFS

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class SerializeDeserializeTree {

    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        val result = StringJoiner(",")
        if (root == null) {
            return "null"
        }
        result.add(root.`val`.toString())
        result.add(serialize(root.left))
        result.add(serialize(root.right))
        return result.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val listIterator = data.split(",").iterator()
        return deserializeDFS(listIterator)
    }

    private fun deserializeDFS(listIterator: Iterator<String>): TreeNode? {
        val element = listIterator.next()
        if (element == "null") {
            return null
        }
        val node = TreeNode(element.toInt())
        node.left = deserializeDFS(listIterator)
        node.right = deserializeDFS(listIterator)
        return node
    }
}

fun main() {
    val obj = SerializeDeserializeTree()
    val node3 = TreeNode(3)
    val node2 = TreeNode(2)
    val node1 = TreeNode(1)
    node1.left = node2
    node1.right = node3
    val serializedStr = obj.serialize(node1)
    println(serializedStr)
    val deserializeTree = obj.deserialize(serializedStr)
    println(deserializeTree)
}
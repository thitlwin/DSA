package dfs.leet_297_serialize_deserialize_BinaryTree

import java.util.StringJoiner

class TreeNode(val `val`: Int){
    var left: TreeNode? = null
    var right: TreeNode? = null
}
class SerializeDeserializeBinaryTree {
    fun serialize(root: TreeNode?): String {
        val sb = StringJoiner(",")
        return serializeDFS(root, sb)
    }

    private fun serializeDFS(root: TreeNode?, sb: StringJoiner): String {
        if (root == null){
            return sb.add("x").toString()
        }
        sb.add("${root.`val`} ")
        serializeDFS(root.left, sb)
        serializeDFS(root.right, sb)
        return sb.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val iterator =  data.split(" ").iterator()
        return deserializeDFS(iterator)
    }

    private fun deserializeDFS(iterator: Iterator<String>): TreeNode? {
        val ch = iterator.next()
        if (ch == "x") {
            return null
        }
        val node = TreeNode(ch.toInt())
        node.left = deserializeDFS(iterator)
        node.right = deserializeDFS(iterator)
        return node
    }
}
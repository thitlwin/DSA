package leetcode_problem_297_DFS

import java.util.LinkedList

class BestAnswer1 {
    fun serialize(root: TreeNode?): String {
        val sb = StringBuilder()
        fun serialize(root: TreeNode?, sb: StringBuilder): StringBuilder {
            if(root == null){
                return sb.append("null,")
            }
            sb.append("${root.`val`},")
            serialize(root.left, sb)
            serialize(root.right, sb)
            return sb
        }
        return serialize(root, sb).toString()
    }

    fun deserialize(data: String): TreeNode? {
        val elementQueue = LinkedList<Int?>()
        data.substring(0, data.length-1).split(",").map {
            if (it == "null")
                elementQueue.add(null)
            else
                elementQueue.add(it.toInt())
        }

        fun deserialize(queue: LinkedList<Int?>): TreeNode? {
            val ele = queue.pop() ?: return null
            val node = TreeNode(ele)
            node.left = deserialize(queue)
            node.right = deserialize(queue)
            return node
        }
        return deserialize(elementQueue)
    }
}

fun main() {
    val obj = BestAnswer1()
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
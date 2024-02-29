package leetcode_problem_897

import binary_tree.BinaryNode

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String = diagram(this)

    private fun diagram(
        node: TreeNode?,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String {
        return node?.let {
            if (node.left == null && node.right == null) {
                "$root${node.`val`}\n"
            } else {
                diagram(node.right, "$top ", "$top┌──", "$top|") +
                        root + "${node.`val`}\n" +
                        diagram(node.left, "$bottom| ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }
}

class IncreasingOrderSearchTree {
    fun increasingBST(root: TreeNode?): TreeNode? {
        val nodeValueList = mutableListOf<Int>()
        traverseInOrder(root) {
            it?.let {
                nodeValueList.add(it)
            }
        }

        var rootNode = TreeNode(nodeValueList.removeFirst()) // if (nodeValueList.isNotEmpty()) TreeNode(nodeValueList.removeFirst()) else null
        val originalRoot = rootNode
        while (nodeValueList.isNotEmpty()) {
            val nextNode = TreeNode(nodeValueList.removeFirst())
            rootNode.right = nextNode
            rootNode = nextNode
        }
        return originalRoot
    }

    private fun traverseInOrder(root: TreeNode?, visitNode: VisitNode<Int?>) {
        root ?: return
        traverseInOrder(root.left, visitNode)
        visitNode(root.`val`)
        traverseInOrder(root.right, visitNode)
    }

}

typealias VisitNode<T> = (T) -> Unit

fun main() {
    val obj = IncreasingOrderSearchTree()
    val _1 = TreeNode(1)
    val _2 = TreeNode(2)
    val _3 = TreeNode(3)
    val _4 = TreeNode(4)
    val _5 = TreeNode(5)
    val _6 = TreeNode(6)
    val _7 = TreeNode(7)
    val _8 = TreeNode(8)
    val _9 = TreeNode(9)

    _5.apply {
        left = _3
        right = _6
    }

    _3.apply {
        left = _2
        right = _4
    }

    _2.apply {
        left = _1
    }

    _6.apply {
        right = _8
    }

    _8.apply {
        left = _7
        right = _9
    }

    val res = obj.increasingBST(_5)
    println(res)
}
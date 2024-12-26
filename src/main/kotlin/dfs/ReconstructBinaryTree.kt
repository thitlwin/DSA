package dfs

class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class ReconstructBinaryTree {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val mapForInOrder = inorder.mapIndexed { index, i -> i to index }.toMap()
        return dfs(preorder, mapForInOrder, preorderStart = 0, inorderStart = 0, size = inorder.size)
    }

    private fun dfs(
        preorder: IntArray,
        mapForInOrder: Map<Int, Int>,
        preorderStart: Int,
        inorderStart: Int,
        size: Int
    ): TreeNode? {
        if (size <= 0) return null

        val rootVal = preorder[preorderStart]
        val node = TreeNode(rootVal)
        val rootIndexInPreOrder = mapForInOrder.getOrDefault(rootVal, 0)
        val leftSize = rootIndexInPreOrder - inorderStart

        node.left = dfs(preorder, mapForInOrder, preorderStart + 1, inorderStart, leftSize)
        node.right = dfs(
            preorder,
            mapForInOrder,
            preorderStart + 1 + leftSize,
            rootIndexInPreOrder + 1,
            size - 1 - leftSize
        )
        return node
    }
}

fun main() {
    val obj = ReconstructBinaryTree()
    val res = obj.buildTree(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7))
    println(res.toString())
}
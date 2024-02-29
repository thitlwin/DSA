package leetcode_problem_100

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        val pList = mutableListOf<Int?>()
        traversePreOrder(p, pList)
        val qList = mutableListOf<Int?>()
        traversePreOrder(q, qList)
        return qList == pList
    }

    private fun traversePreOrder(tree: TreeNode?, qList: MutableList<Int?>) {
        qList.add(tree?.`val`)
        if (tree?.left == null)
            qList.add(null)
        else
            traversePreOrder(tree.left, qList)
        if (tree?.right == null)
            qList.add(null)
        else
            traversePreOrder(tree.right, qList)
    }
}

fun main() {
    val sameTreeChecker = SameTree()
    val p = TreeNode(1)
    val q = TreeNode(1)
    val two = TreeNode(2)
    val three = TreeNode(3)
    val four = TreeNode(4)

    p.left = two
    p.right = three

    q.left = two
    q.right = null

    println("isSameTree => ${sameTreeChecker.isSameTree(p, q)}")

}
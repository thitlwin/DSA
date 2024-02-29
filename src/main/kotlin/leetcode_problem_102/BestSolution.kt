package leetcode_problem_102

class BestSolution {

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val resultList: MutableList<MutableList<Int>> = mutableListOf()

        fun f(root: TreeNode?, depth: Int) {
            if (root == null) return
            if (depth >= resultList.size) {
                resultList.add(mutableListOf())
            }
            resultList[depth].add(root.`val`)
            f(root.left, depth+1)
            f(root.right, depth+1)
        }
        f(root, 0)
        return resultList
    }
}

fun main() {
    val p = TreeNode(1)
    val two = TreeNode(2)
    val three = TreeNode(3)
    val four = TreeNode(4)
    val five = TreeNode(5)

    p.left = two
    p.right = three

    three.right = five
    two.left = four

    val levelOrderTraversal = BestSolution()
    println(levelOrderTraversal.levelOrder(p))
}
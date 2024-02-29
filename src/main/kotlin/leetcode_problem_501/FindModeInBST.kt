package leetcode_problem_501

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class FindModeInBST {
    private val frequencyMap = mutableMapOf<Int, Int>()
    private var maxFrequency = 0
    fun findMode(root: TreeNode?): IntArray {
        if (root == null) return intArrayOf()
        traverseInOrder(root)
        val result = mutableListOf<Int>()
        for ((node, frequency) in frequencyMap) {
            if (frequency == maxFrequency)
                result.add(node)
        }
        return result.toIntArray()
    }

    private fun traverseInOrder(root: TreeNode?) {
        root ?: return
        traverseInOrder(root.left)

        val frequency = frequencyMap.getOrDefault(root.`val`, 0) + 1
        frequencyMap[root.`val`] = frequency
        maxFrequency = maxOf(frequency, maxFrequency)

        traverseInOrder(root.right)
    }
}
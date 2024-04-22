package leetcode_problem_988_smallest_string_from_leaf_to_root

import kotlin.text.StringBuilder

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class SmallestStringFromLeafToRoot {
    fun smallestFromLeaf(root: TreeNode?): String {
        if (root == null) return ""
        val result = StringBuilder()
        dfs(root, "", result)
        return result.toString()
    }

    private fun dfs(root: TreeNode, currentStr: String, result: StringBuilder) {
        val newChar = 'a' + root.`val` + currentStr
        if (root.left == null && root.right == null) {
            if (result.isEmpty() || newChar < result.toString()) {
                result.clear()
                result.append(newChar)
            }
            return
        }

        root.left?.let {
            dfs(it, newChar, result)
        }
        root.right?.let {
            dfs(it, newChar, result)
        }
    }
}

fun main() {
    val obj = SmallestStringFromLeafToRoot()
    val root = TreeNode(25).apply {
        left = TreeNode(1).apply {
            left = TreeNode(1)
            right = TreeNode(3)
        }
        right = TreeNode(3).apply {
            left = TreeNode(0)
            right = TreeNode(2)
        }
    }
    println(obj.smallestFromLeaf(root))
}
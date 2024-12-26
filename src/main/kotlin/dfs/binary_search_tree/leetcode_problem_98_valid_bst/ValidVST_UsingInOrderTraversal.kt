package dfs.binary_search_tree.leetcode_problem_98_valid_bst

class ValidVST_UsingInOrderTraversal {
    fun isValidBST(root: TreeNode?): Boolean {
        val inorderList = inOrderTraversal(root)
        for (i in 1..inorderList.lastIndex){
            if(inorderList[i-1] > inorderList[i]) return false
        }
        return true
    }

    fun inOrderTraversal(root: TreeNode?): List<Int>{
        if(root == null) return emptyList<Int>()
        val result = mutableListOf<Int>()
        result.add(root.`val`)

        val leftList = inOrderTraversal(root.left)
        val rightList = inOrderTraversal(root.right)
        return leftList + result + rightList
    }

    fun preOrderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val result = mutableListOf<Int>()
        result.add(root.`val`)
        val leftList = preOrderTraversal(root.left)
        val rightList = preOrderTraversal(root.right)
        return result + leftList + rightList
    }

    fun postOrderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val result = mutableListOf<Int>()
        result.add(root.`val`)
        val leftList = postOrderTraversal(root.left)
        val rightList = postOrderTraversal(root.right)
        return leftList + rightList + result
    }
}

fun main() {
    val obj = ValidVST_UsingInOrderTraversal()
    val root = TreeNode(6).apply{
        left = TreeNode(4).apply {
            left = TreeNode(3)
            right = TreeNode(5)
        }
        right = TreeNode(8).apply {
//            left = TreeNode(1)
        }
    }
    println(obj.isValidBST(root))
    println(obj.inOrderTraversal(root).joinToString())
    println(obj.preOrderTraversal(root).joinToString())
    println(obj.postOrderTraversal(root).joinToString())
}
package leetcode_problem_501

class BestAnswerWithMorrisTraversal {
    var maxStreak = 0
    var currentStreak = 0
    var currentNum = 0
    var answer = arrayListOf<Int>()
    fun findMode(root: TreeNode?): IntArray {
        var curr = root
        while (curr != null) {
            if (curr.left != null) {
                // find the friend
                var friend = curr.left
                while (friend?.right != null)
                    friend = friend.right
                friend?.right = curr

                // Delete the edge after using it
                val left = curr.left
                curr.left = null
                curr = left
            } else {
                // Handle the current node
                val num = curr.`val`
                if (num == currentNum) {
                    currentStreak++
                } else {
                    currentStreak = 1
                    currentNum = num
                }

                if (currentStreak > maxStreak) {
                    answer = arrayListOf<Int>()
                    maxStreak = currentStreak
                }

                if (currentStreak == maxStreak)
                    answer.add(curr.`val`)

                curr = curr.right
            }
        }

        return answer.toIntArray()
    }
}
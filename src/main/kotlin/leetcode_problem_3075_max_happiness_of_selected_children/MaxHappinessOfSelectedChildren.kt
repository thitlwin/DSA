package leetcode_problem_3075_max_happiness_of_selected_children

class MaxHappinessOfSelectedChildren {
    fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        var result = 0L
        var lastIndex = happiness.size-1
        var childCount = k
        happiness.sort()
        while(childCount > 0) {
            var decreasedAmount = k - childCount
            if(happiness[lastIndex]-decreasedAmount<0)
                result += 0
            else
                result += happiness[lastIndex] - decreasedAmount
            childCount--
            lastIndex--
        }
        return result
    }
}
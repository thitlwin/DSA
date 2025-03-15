package two_pointers.leet_167_2sum_II

class TwoSum_II_HashMap_Approach {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hm = hashMapOf<Int,Int>()
        nums.forEachIndexed{index, num ->
            val complement = target - num
            if(complement in hm)
                return intArrayOf(index + 1, hm[complement]!! + 1).sortedArray()
            hm[num] = index
        }
        return intArrayOf()
    }
}
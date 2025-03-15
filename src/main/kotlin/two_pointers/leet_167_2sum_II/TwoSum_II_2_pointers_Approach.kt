package two_pointers.leet_167_2sum_II

class TwoSum2 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var front = 0
        var rare = numbers.size - 1
        while (front < rare) {
            val twoSum = numbers[front] + numbers[rare]
            if (twoSum == target) {
                return intArrayOf(front + 1, rare + 1)
            } else if (twoSum > target) {
                rare--
            } else {
                front++
            }
        }
        return intArrayOf()
    }
}

fun main() {
    val obj = TwoSum2()
//    val res = obj.twoSum(intArrayOf(2, 7, 11, 15), 9)
    val res = obj.twoSum(intArrayOf(3,2,4), 6)

    println(res.joinToString())
}
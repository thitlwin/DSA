package leetcode_problem_881_2pointers

class MyAnswer {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var weight = 0
        var count = 0
        var left = 0
        var right = people.lastIndex
        while(left <= right)  {
            weight = people[left] + people[right]
            while(weight < limit) {
                left++
                weight += people[left]
            }
            if(weight > limit) {
                weight -= people[left]
            }
            if(weight <= limit) {
                count++
            }
            right--
        }
        return count
    }
}

fun main() {
    val obj = MyAnswer()
    println(obj.numRescueBoats(intArrayOf(3,5,3,4), 5))
}
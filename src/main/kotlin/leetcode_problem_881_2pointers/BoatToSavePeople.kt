package leetcode_problem_881_2pointers

class BoatToSavePeople {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var l =  0
        var r = people.size - 1
        var numberOfBoats = 0
        while(l <= r) {
            if(people[l] + people[r] <= limit) {
                l++
            }
            numberOfBoats++
            r--
        }
        return numberOfBoats
    }
}

fun main() {
    val obj = BoatToSavePeople()
    println(obj.numRescueBoats(intArrayOf(3,2,2,1), 3))//3
//    println(obj.numRescueBoats(intArrayOf(1,2), 3))//1
//    println(obj.numRescueBoats(intArrayOf(3,5,3,4), 5))//4
}
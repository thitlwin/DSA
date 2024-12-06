package binary_search.leet729_calendar_event

class MyCalendar {
    val calendar = mutableListOf<IntArray>()
    fun book(startTime: Int, endTime: Int): Boolean {
        var left = 0
        var right = calendar.size - 1
        var index = calendar.size
        while(left <= right) {
            val mid = left + (right - left) / 2
            if (calendar[mid][0] > startTime){
                index = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        if ((index > 0 && calendar[index-1][1] > startTime) || index < calendar.size)
            return false
        calendar.add(index, intArrayOf(startTime, endTime))
        return true
    }
}

fun main() {
    val obj = MyCalendar()
//    [[],[10,20],[15,25],[20,30]]
//    println(obj.book(10,20))
//    println(obj.book(15,25))
//    println(obj.book(20,30))
//    [[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
    println(obj.book(47,50))
//    println(obj.book(33,41))
    println(obj.book(39,45))

}
package leetcode_problem_1171_RemoveZeroSumConsecutive
data class ListNode(val `val`: Int){
    var next: ListNode? = null
}
class RemoveZeroSumConsecutiveNodes {
    fun removeZeroSumSublists(head: ListNode?): ListNode? {
        var front = ListNode(0).apply { next = head }
        var start: ListNode? = front
        while (start != null) {
            var prefixSum = 0
            var end = start.next
            while (end != null) {
                prefixSum += end.`val`
                if (prefixSum == 0) {
                    start.next = end.next
                }
                end = end.next
            }
            start = start.next
        }
        return front.next
    }
}

fun main() {
    val obj = RemoveZeroSumConsecutiveNodes()
    val node1 = ListNode(1).apply { next = ListNode(2).apply { next = ListNode(3).apply { next = ListNode(-3).apply  { next = ListNode(4) }} } }
    println(obj.removeZeroSumSublists(node1))
}
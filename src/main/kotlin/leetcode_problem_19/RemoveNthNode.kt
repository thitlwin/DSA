package leetcode_problem_19

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
class RemoveNthNode {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0).apply { next = head }
        var slow: ListNode? = dummy
        var fast: ListNode? = dummy
        repeat(n){
            fast = fast?.next
        }
        while (fast?.next != null){
            slow = slow?.next
            fast = fast?.next
        }
        slow?.next = slow?.next?.next
        return dummy.next
    }
}

fun main() {
    val obj = RemoveNthNode()
    val n1 = ListNode(1).apply { next = ListNode(2).apply { next = ListNode(3).apply { next = ListNode(4).apply { next = ListNode(5) } } } }
    val result = obj.removeNthFromEnd(n1, 2)
}
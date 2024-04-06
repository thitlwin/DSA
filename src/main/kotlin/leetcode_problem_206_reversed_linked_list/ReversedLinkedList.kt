package leetcode_problem_206_reversed_linked_list

data class ListNode(val `val`: Int) {
    var next: ListNode? = null
}

class ReversedLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        val dummy = ListNode(-1)
        var current = head
        while (current != null) {
            val next = current.next
            current.next = dummy.next
            dummy.next = current
            current = next
        }
        return dummy.next
    }
}

fun main() {
    val obj = ReversedLinkedList()
    val node1 = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }
    println(obj.reverseList(node1))
}
package leetcode_problem_206_reversed_linked_list

class BestAnswer1 {
    fun reverseList(head: ListNode?): ListNode? {
        var current = head
        var prev: ListNode? = null
        var next: ListNode? = null
        while (current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next
        }
        return prev
    }
}

fun main() {
    val obj = BestAnswer1()
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
package leetcode_problem_143_reorder_list

class BestAnswer1 {
    fun reorderList(head: ListNode?): Unit {
        var fast = head
        var slow = head
        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        var current = slow?.next
        slow?.next = null
        var previous: ListNode? = null
        while (current != null) {
            val temp = current.next
            current.next = previous
            previous = current
            current = temp
        }

        current = head
        while (previous != null) {
            val temp = previous.next
            previous.next = current?.next
            current?.next = previous
            current = previous.next
            previous = temp
        }
    }
}

fun main() {
    val obj = BestAnswer1()
    val node1 = ListNode(1)
        .apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4)
                    .apply {
                    next = ListNode(5)
                }
            }
        }
    }
    println(obj.reorderList(node1))
}
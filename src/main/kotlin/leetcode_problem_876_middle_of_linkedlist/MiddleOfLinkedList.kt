package leetcode_problem_876_middle_of_linkedlist

data class ListNode(val `val`: Int) {
    var next: ListNode? = null
}

class MiddleOfLinkedList {
    fun middleNode(head: ListNode?): ListNode? {
        var count = 0
        val hm = HashMap<Int, ListNode?>()
        var pointer = head
        hm[count] = head
        while (pointer?.next != null) {
            count++
            pointer = pointer.next
            hm[count] = pointer
        }
        return hm[(count + 1) / 2]
    }
}

fun main() {
    val obj = MiddleOfLinkedList()
    val n1 = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4)
                    .apply { next = ListNode(5).apply { next = ListNode(6) } }
            }
        }
    }
    print(obj.middleNode(n1))
}
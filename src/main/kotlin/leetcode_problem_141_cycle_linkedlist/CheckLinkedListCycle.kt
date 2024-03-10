package leetcode_problem_141_cycle_linkedlist
data class ListNode(val `val`: Int) {
    var next: ListNode? = null
}
class CheckLinkedListCycle {
    fun hasCycle(head: ListNode?): Boolean{
        var slow = head
        var fast = head
        while(fast?.next != null){
            slow = slow?.next
            fast = fast.next?.next
            if (slow == fast)
                return true
        }
        return false
    }
}

fun main() {
    val obj = CheckLinkedListCycle()
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    node1.next = node2
    node2.next = node3
    node3.next = node4
//    node4.next = node2
    println(obj.hasCycle(node1))
}
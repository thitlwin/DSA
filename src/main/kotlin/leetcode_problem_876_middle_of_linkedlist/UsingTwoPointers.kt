package leetcode_problem_876_middle_of_linkedlist

class UsingTwoPointers {
    fun middleNode(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        while(fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }
}

fun main() {
    val obj =UsingTwoPointers()
    val n1 = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4)
                    .apply { next = ListNode(5) }
            }
        }
    }
    println(obj.middleNode(n1))
    var ch = "abcd".toCharArray()
    println(ch.toString())
}
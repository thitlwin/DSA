package leetcode_problem_143_reorder_list
data class ListNode(val `val`: Int) {
    var next: ListNode? = null
}

class ReorderList {
    fun reorderList(head: ListNode?): Unit {
        head ?: return
        // find middle node
        var fast = head.next
        var slow = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        // reverse second half nodes (after middle node)
        var dummy = ListNode(-1)
        while (slow != null) {
            val next = slow.next
            slow.next = dummy.next
            dummy.next = slow
            slow = next
        }

        // sort
        var h = head
        var t = dummy.next
        if (h == t) return
        var headTurn = true
        while(h != null && t != null) {
            if (t.next == h){
                if(!headTurn) return
                t.next = null
                h.next = t
                return
            }
            if (h.next == t) return
            if (headTurn) {
                val nextHead = h.next
                h.next = t
                h = nextHead
            } else {
                val nextTail = t.next
                t.next = h
                t = nextTail
            }
            headTurn = !headTurn
        }
    }
}

fun main() {
    val obj = ReorderList()
    val node1 = ListNode(1)
//        .apply {
//        next = ListNode(2).apply {
//            next = ListNode(3).apply {
//                next = ListNode(4)
//                    .apply {
//                    next = ListNode(5)
//                }
//            }
//        }
//    }
    println(obj.reorderList(node1))
}
package heap.leet_23_merge_k_sorted_list

import java.util.PriorityQueue

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    //    fun printListNode(head: ListNode?) {
//    var current = head
//    while (current != null) {
//        print("${current.`val`} -> ")
//        current = current.next
//    }
//    println("null")
//}
    fun printListNode() {
        var current:ListNode? = this
        while (current != null) {
            print("${current.`val`} -> ")
            current = current.next
        }
    }
}

class MergeKSortedList {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val comparator = compareBy<ListNode>{ it.`val` }
        val heap: PriorityQueue<ListNode> = PriorityQueue(comparator)
        lists.forEach {
            if(it != null) {
                heap.add(it)
            }
        }

        val dummyNode = ListNode(0)
        var current = dummyNode
        while(heap.isNotEmpty()) {
            val smallestNode = heap.poll()
            if(smallestNode.next != null) {
                heap.offer(smallestNode.next)
            }
            current.next = smallestNode
            current = current.next!!
        }
        return dummyNode.next
    }
//    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
//        val comparator = compareBy<ListNode> { it.`val` }
//        val heap: PriorityQueue<ListNode> = PriorityQueue(comparator)
//        lists.forEach {
//            if (it != null) {
//                heap.add(it)
//            }
//        }// O(k logk), where k is element in list
//        val dummyHead = ListNode(0)
//        var current: ListNode = dummyHead
//        while (heap.isNotEmpty()) {
//            val smallestNode = heap.poll() // O(log k)
//            if (smallestNode.next != null) {
//                heap.offer(smallestNode.next)
//            }
//
//            current.next = smallestNode
//            current = current.next!!
//        }
//        return dummyHead.next
//    }
}

//[[1,4,5],[1,3,4],[2,6]]
fun main() {
    val obj = MergeKSortedList()

    val node1 = ListNode(1).apply {
        next = ListNode(4).apply {
            next = ListNode(5)
        }
    }
    val node2 = ListNode(1).apply {
        next = ListNode(3).apply {
            next = ListNode(4)
        }
    }

    val node3 = ListNode(2).apply {
        next = ListNode(6)
    }
    val res = obj.mergeKLists(arrayOf(node1, node2, node3))
    res?.printListNode()
}
package two_pointers

data class Node<T>(val `val`: T) {
    var next: Node<T>? = null
}

class MiddleOfLinkedList {
    fun middleOfLinkedList(head: Node<Int>): Int? {
        var slow: Node<Int>? = head
        var fast: Node<Int>? = head
        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
        }
        return slow?.`val`
    }
}

fun main() {
    val obj = MiddleOfLinkedList()
    val n0 = Node(0)
    val n1 = Node(1)
    val n2 = Node(2)
    val n3 = Node(3)
    val n4 = Node(4)
//    val n5 = Node(5)
    n0.next = n1
    n1.next = n2
    n2.next = n3
    n3.next = n4
//    n4.next = n5
    println(obj.middleOfLinkedList(n0))
}
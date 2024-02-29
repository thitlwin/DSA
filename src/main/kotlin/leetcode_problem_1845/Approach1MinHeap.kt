package leetcode_problem_1845

import java.util.PriorityQueue

/*
*
* Min Heap
* This data structure is a complete binary tree, where the parent nodes are always smaller than the corresponding
* child nodes, in order to keep the minimum-valued element at the root node of the tree.
* Here, pushing an element and popping an element are both logarithmic time operations,
* but getting the minimum-valued element is a constant time operation.
* */
class Approach1MinHeap(val n: Int) {
    private val availableSeats = PriorityQueue<Int>()
    init {
        repeat(n) {
            availableSeats.add(it) // O(n.log n)
        }
    }

    fun reserve(): Int {
        return availableSeats.poll() // O(log n)
    }

    fun unreserve(seatNumber: Int) {
        availableSeats.offer(seatNumber) // O(log n)
    }
}

/*
* Let m be the maximum number of calls made.
* Time Complexity: O((m+n)⋅logn)
* Space complexity: O(n)
*
* */
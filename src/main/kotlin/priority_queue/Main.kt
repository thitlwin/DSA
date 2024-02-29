fun main() {

    "max priority queue" example {
        val priorityQueue = ComparablePriorityQueueImpl<Int>()
        arrayListOf(1, 12, 3, 4, 1, 6, 8, 7).forEach {
            priorityQueue.enqueue(it)
        }
        while (!priorityQueue.isEmpty) {
            println(priorityQueue.dequeue())
        }
    }

    "min priority queue" example {
        val stringLengthComparator = Comparator<String> { o1, o2 ->
            val length1 = o1?.length ?: -1
            val length2 = o2?.length ?: -1
            length1 - length2
        }
        val priorityQueue = ComparatorPriorityQueueImpl(stringLengthComparator)
        arrayListOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine").forEach {
            priorityQueue.enqueue(it)
        }
        while (!priorityQueue.isEmpty) {
            println(priorityQueue.dequeue())
        }
    }

    "max priority array list based queue" example {
        val priorityQueue = CustomPriorityQueueArrayList<Int>()
        arrayListOf(1, 12, 3, 4, 1, 6, 8, 7).forEach {
            priorityQueue.enqueue(it)
        }
        priorityQueue.enqueue(5)
        priorityQueue.enqueue(0)
        priorityQueue.enqueue(10)
        while (!priorityQueue.isEmpty) {
            println(priorityQueue.dequeue())
        }
    }

    "concert line" example {
        val p1 = Person("Josh", 21, true)
        val p2 = Person("Jake", 22, true)
        val p3 = Person("Clay", 28, false)
        val p4 = Person("Cindy", 28, false)
        val p5 = Person("Sabrina", 30, false)
        val priorityQueue =
            ComparatorPriorityQueueImpl(MilitaryPersonComparator)
        arrayListOf(p1, p2, p3, p4, p5).forEach {
            priorityQueue.enqueue(it)
        }
        while (!priorityQueue.isEmpty) {
            println(priorityQueue.dequeue())
        }
    }
}

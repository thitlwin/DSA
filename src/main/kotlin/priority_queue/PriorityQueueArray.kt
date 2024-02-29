import java.util.*
import kotlin.collections.ArrayList

abstract class AbstractPriorityQueueArrayList<T : Any> : Queue<T> {
    protected val elements = ArrayList<T>()
    abstract fun sort()

    override val count: Int
        get() = elements.size

    override fun peek(): T? = elements.firstOrNull()

    override fun dequeue(): T? {
        return if (isEmpty) null else elements.removeAt(0)
    }

    override fun enqueue(element: T): Boolean {
        elements.add(element)
        sort()
        return true
    }

    override fun toString(): String {
        return elements.toString()
    }
}

class ComparablePriorityQueueArrayList<T : Comparable<T>> :
    AbstractPriorityQueueArrayList<T>() {
    override fun sort() {
        elements.sort()
    }
}

class ComparatorPriorityQueueArrayList<T : Any>(
    private val comparator: Comparator<T>
) : AbstractPriorityQueueArrayList<T>() {
    override fun sort() {
        Collections.sort(elements, comparator)
    }
}

class CustomPriorityQueueArrayList<T: Comparable<T>>: AbstractPriorityQueueArrayList<T>() {
    override fun sort() {
        var index = count - 2
        while (index >= 0 && elements[index + 1].compareTo(elements[index]) > 0) {
            swap(index, index + 1)
            index--
        }
    }

    private fun swap(i: Int, j:Int) {
        val tmp = elements[i]
        elements[i] = elements[j]
        elements[j] = tmp
    }

}
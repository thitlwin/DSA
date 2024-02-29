import list.ArrayListQueue
import java.util.*

class TreeNode<T>(val value: T) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()
    private fun add(child: TreeNode<T>) = children.add(child)

    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }

    fun forEachLevelFirst(visit: Visitor<T>) {
        val queue = ArrayDeque<TreeNode<T>>()
        visit(this)
        queue.addAll(this.children)

        var elementInQueue = if (queue.isNotEmpty()) queue.pop() else null
        while (elementInQueue != null) {
            visit(elementInQueue)
            queue.addAll(elementInQueue.children)

            elementInQueue = if (queue.isNotEmpty()) queue.pop() else null
        }
    }

    fun printEachLevel() {
        val queue = ArrayDeque<TreeNode<T>>()
        queue.add(this)

        var simblingCount = queue.size
        var elementInQueue = if (queue.isEmpty()) null else queue.pop()

        while (elementInQueue != null) {
            print("${elementInQueue.value} ")
            queue.addAll(elementInQueue.children)
            simblingCount--
            if (simblingCount == 0) {
                println()
                simblingCount = queue.size
            }
            elementInQueue = if (queue.isEmpty()) null else queue.pop()
        }
    }

    fun printEachLevel_SolutionFromBook() {
        val queue = ArrayListQueue<TreeNode<T>>()
        var nodesLeftInCurrentLevel = 0

        queue.enqueue(this)
        while (queue.isEmpty.not()) {
            nodesLeftInCurrentLevel = queue.count

            while (nodesLeftInCurrentLevel > 0) {
                val node = queue.dequeue()
                node?.let {
                    print("${node.value} ")
                    node.children.forEach { queue.enqueue(it) }
                    nodesLeftInCurrentLevel--
                } ?: break
            }

            println()
        }
    }

    fun search(value: T): TreeNode<T>? {
        var resultNode: TreeNode<T>? = null
        this.forEachLevelFirst {
            if (it.value == value)
                resultNode = it
        }
        return resultNode
    }

    fun makeBeverageTree(): TreeNode<String> {
        val beverageTree = TreeNode("Beverages")

        val hot = TreeNode("Hot")
        val cold = TreeNode("Cold")

        val tea = TreeNode("tea")
        val coffee = TreeNode("coffee")
        val chocolate = TreeNode("cocoa")

        val blackTea = TreeNode("black")
        val greenTea = TreeNode("green")
        val chaiTea = TreeNode("chai")

        val soda = TreeNode("soda")
        val milk = TreeNode("milk")

        val gingerAle = TreeNode("ginger ale")
        val bitterLemon = TreeNode("bitter lemon")

        beverageTree.run {
            add(hot)
            add(cold)
        }

        hot.run {
            add(tea)
            add(coffee)
            add(chocolate)
        }

        cold.run {
            add(soda)
            add(milk)
        }

        tea.run {
            add(blackTea)
            add(greenTea)
            add(chaiTea)
        }

        soda.run {
            add(gingerAle)
            add(bitterLemon)
        }
        return beverageTree
    }
}

typealias Visitor<T> = (TreeNode<T>) -> Unit

fun main() {
    val myTree = TreeNode("MyTree")
    val tree = myTree.makeBeverageTree()
    tree.forEachDepthFirst { println(it.value) }

//    tree.forEachLevelFirst { println(it.value) }
//    tree.search("chai")?.let {
//        println(it.value)
//    } ?: println("Couldn't find")
//    tree.printEachLevel()
//    println()
//    tree.printEachLevel_SolutionFromBook()
}
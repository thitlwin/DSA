package binary_tree

typealias Visitor<T> = (T) -> Unit

class BinaryNode<T>(var value: T) {
    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null

    val min: BinaryNode<T>?
        get() = leftChild?.min ?: this

    override fun toString(): String = diagram(this)

    private fun diagram(
        node: BinaryNode<T>?,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top|") +
                        root + "${node.value}\n" +
                        diagram(node.leftChild, "$bottom| ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }

    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    fun traversePreOrder(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    fun traversePreOrderWithNull(visit: Visitor<T?>) {
        visit(value)
        leftChild?.traversePreOrderWithNull(visit) ?: visit(null)
        rightChild?.traversePreOrderWithNull(visit) ?: visit(null)
    }

    fun traversePostOrder(visit: Visitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }

    fun treeHeight(node: BinaryNode<T>? = this): Int {
        return node?.let {
            1 + maxOf(treeHeight(node.leftChild), treeHeight(node.rightChild))
        } ?: -1
    }

    fun height(): Int {
        return (1 + maxOf(this.leftChild?.height()?:-1, this.rightChild?.height()?:-1)) ?: -1
    }

    fun seraializeToListUsingPreorder(node: BinaryNode<T>? = this): MutableList<T?> {
        val result = mutableListOf<T?>()
        node?.traversePreOrderWithNull {
            result.add(it)
        }
        return result
    }

    fun deserialize(list: MutableList<T?>): BinaryNode<T?>? {
        val rootValue = list.removeAt(list.size - 1) ?: return null
        val root = BinaryNode<T?>(rootValue)
        root.leftChild = deserialize(list)
        root.rightChild = deserialize(list)
        return root
    }

    fun deserializeOptimized(list: MutableList<T?>): BinaryNode<T?>? {
        return deserialize(list.asReversed())
    }
}

fun main() {
//    val zero = BinaryNode(0)
//    val one = BinaryNode(1)
//    val five = BinaryNode(5)
//    val seven = BinaryNode(7)
//    val eight = BinaryNode(8)
//    val nine = BinaryNode(9)
//    val ten = BinaryNode(10)
//
//    seven.leftChild = one
//    one.leftChild = zero
//    one.rightChild = five
//    seven.rightChild = nine
//    nine.leftChild = eight
//    eight.rightChild = ten
//
//    val tree = seven
    val _1 = BinaryNode(1)
    val _2 = BinaryNode(2)
    val _3 = BinaryNode(3)
    val _4 = BinaryNode(4)
    val _5 = BinaryNode(5)
    val _6 = BinaryNode(6)
    val _7 = BinaryNode(7)
    val _8 = BinaryNode(8)
    val _9 = BinaryNode(9)

    _5.apply {
        leftChild = _3
        rightChild = _6
    }

    _3.apply {
        leftChild = _2
        rightChild = _4
    }

    _2.apply {
        leftChild = _1
    }

    _6.apply {
        rightChild = _8
    }

    _8.apply {
        leftChild = _7
        rightChild = _9
    }
    val tree = _5
    println(tree)

    tree.traverseInOrder { println(it) }
//    tree.traversePostOrder { println(it)  }
//    tree.traversePreOrder { println(it) }
//    println("treeHeight=${tree.treeHeight()}")
//    val list = tree.seraializeToListUsingPreorder()
//    println(list)
//    val tr = tree.deserializeOptimized(list)
//    println(tr)
    println("treeHeight=${tree.treeHeight()}")
    println("height=${tree.height()}")

}
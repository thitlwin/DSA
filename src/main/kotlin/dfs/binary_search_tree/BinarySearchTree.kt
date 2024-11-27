package dfs.binary_search_tree

import binary_tree.BinaryNode
import util.example

class BinarySearchTree<T: Comparable<T>> {
    var root: BinaryNode<T>? = null
    override fun toString() = root?.toString() ?: "empty tree"

    fun insert(value: T) {
        root = insert(root, value)
    }

    private fun insert(root: BinaryNode<T>?, value: T): BinaryNode<T> {
        root ?: return BinaryNode(value)
        if (value < root.value) {
            root.leftChild = insert(root.leftChild, value)
        } else {
            root.rightChild = insert(root.rightChild, value)
        }
        return root
    }

    fun contains(value: T): Boolean {
        var current = root
        while (current != null) {
            if (current.value == value) return true
            current = if (value < current.value) current.leftChild
            else current.rightChild
        }
        return false
    }

    fun remove(value: T) {
        root = remove(root, value)
    }

    private fun remove(node: BinaryNode<T>?, value: T): BinaryNode<T>? {
        node ?: return null
        when {
            value == node.value -> {
                if (node.leftChild == null && node.rightChild == null)
                    return null
                if (node.leftChild == null)
                    return node.rightChild
                if (node.rightChild == null)
                    return node.leftChild
                node.rightChild?.min?.value?.let {
                    node.value = it
                }
                node.rightChild = remove(node.rightChild, node.value)
            }
            value < node.value -> node.leftChild = remove(node.leftChild, value)
            else -> node.rightChild = remove(node.rightChild, value)
        }
        return node
    }
}

fun main() {
    val exampleTree = BinarySearchTree<Int>().apply {
        insert(3)
        insert(1)
        insert(4)
        insert(0)
        insert(2)
        insert(5)
    }

//    "building a BST" example {
////        val bst = BinarySearchTree<Int>()
////        (0..4).forEach {
////            bst.insert(it)
////        }
//        println(exampleTree)
//    }
//
//    "finding a node" example {
//        if (exampleTree.contains(5)) {
//            println("Found 5!")
//        } else {
//            println("Couldn't find 5")
//        }
//    }

    "removing a node" example {
        println("Tree before removal:")
        println(exampleTree)
        exampleTree.remove(3)
        println("Tree after removal root:")
        println(exampleTree)
    }
}
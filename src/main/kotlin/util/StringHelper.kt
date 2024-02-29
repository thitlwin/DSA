package util

infix fun String.example(content: () -> Unit) {
    println("----example of $this---")
    content()
    println("----end of $this----")
}
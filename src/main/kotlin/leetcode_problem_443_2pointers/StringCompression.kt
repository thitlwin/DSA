package leetcode_problem_443_2pointers

class StringCompression {
    fun compress(chars: CharArray): Int {
        fun compressChar(w: Int, current: Char, counter: Int): Int {
            var write = w
            chars[write] = current
            write += 1
            if (counter == 1)
                return write
            val length = counter.toString()
            for (c in length){
                chars[write] = c
                write++
            }
            return write
        }

        var write = 0
        var counter = 1
        var current = chars[0]
        for (read in 1 until chars.size) {
            if (chars[read] == current)
                counter++
            else {
                write = compressChar(write, current, counter)
                counter = 1
            }
            current = chars[read]
        }
        write = compressChar(write, current, counter)
        return write
    }
}

fun main() {
    val obj = StringCompression()
    val res = obj.compress(charArrayOf('a','a','b','b','c','c','c')) //6
//    val res = obj.compress(charArrayOf('a')) //1
//    val res = obj.compress(charArrayOf('a','b','b','b','b','b','b','b','b','b','b','b','b')) //4
    println(res)
}
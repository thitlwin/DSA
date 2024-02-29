package graph

data class Coordinate(var row: Int, var col: Int) {
    fun add(other: Coordinate): Coordinate {
        return Coordinate(row + other.row, col + other.col)
    }
}
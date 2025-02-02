package graph.wall_and_gate

import kotlin.test.Test
import kotlin.test.assertEquals

class Leet286WallAndGate2Test {
    val obj = Leet_286_WallAndGate_2()

    @Test
    fun testStandardCase() {
        val input = mutableListOf(
            mutableListOf(Int.MAX_VALUE, -1, 0, Int.MAX_VALUE),
            mutableListOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE, -1),
            mutableListOf(Int.MAX_VALUE, -1, Int.MAX_VALUE, -1),
            mutableListOf(0, -1, Int.MAX_VALUE, Int.MAX_VALUE)
        )
        val expected = mutableListOf(
            mutableListOf(3, -1, 0, 1),
            mutableListOf(2, 2, 1, -1),
            mutableListOf(1, -1, 2, -1),
            mutableListOf(0, -1, 3, 4)
        )
        obj.wallsAndGates(input)
        assertEquals(expected, input)
    }

    @Test
    fun testAllGates() {
       val input = mutableListOf(
                mutableListOf(0, 0),
        mutableListOf(0, 0)
        )
        val expected = listOf(
            listOf(0, 0),
            listOf(0, 0)
        )
        obj.wallsAndGates(input)
        assertEquals(expected, input)
    }


    @Test
    fun testAllWalls() {
        val input = mutableListOf(
            mutableListOf(-1, -1),
            mutableListOf(-1, -1)
        )
        val expected = listOf(
            listOf(-1, -1),
            listOf(-1, -1)
        )
        obj.wallsAndGates(input)
        assertEquals(expected, input)
    }

    @Test
    fun testNoGates() {
        val input = mutableListOf(
            mutableListOf(Int.MAX_VALUE, -1),
            mutableListOf(Int.MAX_VALUE, Int.MAX_VALUE)
        )
        val expected = listOf(
            listOf(Int.MAX_VALUE, -1),
            listOf(Int.MAX_VALUE, Int.MAX_VALUE)
        )
        obj.wallsAndGates(input)
        assertEquals(expected, input)
    }

    @Test
    fun testUnreachableRooms() {
        val input = mutableListOf(
            mutableListOf(0, -1, Int.MAX_VALUE),
            mutableListOf(-1, -1, Int.MAX_VALUE),
            mutableListOf(Int.MAX_VALUE, Int.MAX_VALUE, 0)
        )
        val expected = listOf(
            listOf(0, -1, 2),
            listOf(-1, -1, 1),
            listOf(2, 1, 0)
        )
        val res = obj.wallsAndGates(input)
        assertEquals(expected, res)
    }

    @Test
    fun testSingleCellGrid() {
        val inputGate = mutableListOf(mutableListOf(0))
        obj.wallsAndGates(inputGate)
        assertEquals(listOf(listOf(0)), inputGate)

        val inputWall = mutableListOf(mutableListOf(-1))
        obj.wallsAndGates(inputWall)
        assertEquals(listOf(listOf(-1)), inputWall)

        val inputRoom = mutableListOf(mutableListOf(Int.MAX_VALUE))
        obj.wallsAndGates(inputRoom)
        assertEquals(listOf(listOf(Int.MAX_VALUE)), inputRoom)
    }
    @Test
    fun testMultipleGatesSameRoom() {
        val input = mutableListOf(
            mutableListOf(0, Int.MAX_VALUE, Int.MAX_VALUE, 0),
            mutableListOf(Int.MAX_VALUE, -1, Int.MAX_VALUE, Int.MAX_VALUE),
            mutableListOf(Int.MAX_VALUE, Int.MAX_VALUE, -1, Int.MAX_VALUE),
            mutableListOf(0, Int.MAX_VALUE, Int.MAX_VALUE, 0)
        )
        val expected = listOf(
            listOf(0, 1, 1, 0),
            listOf(1, -1, 2, 1),
            listOf(1, 2, -1, 1),
            listOf(0, 1, 1, 0)
        )
        val res = obj.wallsAndGates(input)
        assertEquals(expected, res)
    }

    @Test
    fun testEmptyGrid() {
        val input = mutableListOf<MutableList<Int>>()
        obj.wallsAndGates(input) // Should handle gracefully (no crash)
        assertEquals(emptyList<List<Int>>(), input)
    }

    @Test
    fun testMixedGatesAndWalls() {
        val input = mutableListOf(
            mutableListOf(0, -1, Int.MAX_VALUE),
            mutableListOf(Int.MAX_VALUE, -1, 0),
            mutableListOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE)
        )
        val expected = listOf(
            listOf(0, -1, 1),
            listOf(1, -1, 0),
            listOf(2, 2, 1)
        )
        val res = obj.wallsAndGates(input)
        assertEquals(expected, res)
    }
}

//./gradlew test --tests graph.wall_and_gate.Leet286WallAndGate2Test.testStandardCase
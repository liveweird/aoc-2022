import kotlin.test.*

class Day03Test {
    @Test
    fun testReadFile() {
        val result = Day03.readInput("./input/Day03a.txt")
        assertEquals(result.size, 6)
    }

    @Test
    fun testCalcResult1() {
        val pairs = Day03.readInput("./input/Day03a.txt")
        val map = Day03.findDupes(pairs)
        val points = Day03.calcPoints(map)
        assertEquals(points, 157)
    }

    @Test
    fun testCalcResult2() {
        val pairs = Day03.readInput("./input/Day03b.txt")
        val map = Day03.findDupes(pairs)
        val points = Day03.calcPoints(map)
        assertEquals(points, 7691)
    }

    @Test
    fun testCalcResult3() {
        val triples = Day03.readInput2("./input/Day03a.txt")
        val map = Day03.findDupes2(triples)
        val points = Day03.calcPoints(map.toList())
        assertEquals(points, 70)
    }

    @Test
    fun testCalcResult4() {
        val triples = Day03.readInput2("./input/Day03b.txt")
        val map = Day03.findDupes2(triples)
        val points = Day03.calcPoints(map.toList())
        assertEquals(points, 2508)
    }
}
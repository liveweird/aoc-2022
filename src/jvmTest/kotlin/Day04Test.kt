import kotlin.test.*

class Day04Test {

    @Test
    fun testReadFile() {
        val result = Day04.readInput("./input/Day04a.txt")
        assertEquals(result.size, 6)
    }

    @Test
    fun testCountPoints1() {
        val pairs = Day04.readInput("./input/Day04a.txt")
        val points = Day04.countPoints(pairs)
        assertEquals(points, 2)
    }

    @Test
    fun testCountPoints2() {
        val pairs = Day04.readInput("./input/Day04b.txt")
        val points = Day04.countPoints(pairs)
        assertEquals(points, 518)
    }

    @Test
    fun testCountPoints3() {
        val pairs = Day04.readInput("./input/Day04a.txt")
        val points = Day04.countPoints2(pairs)
        assertEquals(points, 4)
    }

    @Test
    fun testCountPoints4() {
        val pairs = Day04.readInput("./input/Day04b.txt")
        val points = Day04.countPoints2(pairs)
        assertEquals(points, 909)
    }
}
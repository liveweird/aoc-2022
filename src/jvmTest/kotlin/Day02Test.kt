import kotlin.test.*
class Day02Test {
    @Test
    fun testReadFile() {
        val result = Day02.readInput("./input/Day02a.txt")
        assertEquals(result.size, 3)
    }

    @Test
    fun testCountPoints1() {
        val result = Day02.readInput("./input/Day02a.txt")
        val points = Day02.countPoints(result)
        assertEquals(points, 15)
    }

    @Test
    fun testCountPoints2() {
        val result = Day02.readInput("./input/Day02b.txt")
        val points = Day02.countPoints(result)
        assertEquals(points, 13682)
    }
}
import kotlin.test.*
class Day01Test {
    @Test
    fun testReadFile() {
        val result = Day01.readInput("./input/Day01a.txt")
        assertEquals(result.size, 5)
    }
}
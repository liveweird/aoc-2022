import kotlin.test.*

class Day05Test {
    @Test
    fun testReadFile() {
        val input = Day05.readInput("./input/Day05a.txt", 3)
        assertEquals(input.first.size, 3)
        assertEquals(input.second.size, 4)
    }

    @Test
    fun ProcessCommands() {
        val pair = Day05.readInput("./input/Day05a.txt", 3)
        val processed = Day05.process(pair.first, pair.second)
        assertEquals(processed, listOf('C', 'M', 'Z'))
    }

    @Test
    fun ProcessCommands2() {
        val pair = Day05.readInput("./input/Day05b.txt", 9)
        val processed = Day05.process(pair.first, pair.second)
        assertEquals(processed, listOf('H', 'B', 'T', 'M', 'T', 'B', 'S', 'D', 'C'))
    }
}
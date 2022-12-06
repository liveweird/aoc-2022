import kotlin.test.*

class Day06Test {
    @Test
    fun testFindDupe1() {
        val input = Day06.readInput("./input/Day06a.txt")
        val idx = Day06.waitUntilDupe(input)
        assertEquals(idx, 7)
    }

    @Test
    fun testFindDupe2() {
        val input = Day06.readInput("./input/Day06b.txt")
        val idx = Day06.waitUntilDupe(input)
        assertEquals(idx, 5)
    }

    @Test
    fun testFindDupe3() {
        val input = Day06.readInput("./input/Day06c.txt")
        val idx = Day06.waitUntilDupe(input)
        assertEquals(idx, 6)
    }

    @Test
    fun testFindDupe4() {
        val input = Day06.readInput("./input/Day06d.txt")
        val idx = Day06.waitUntilDupe(input)
        assertEquals(idx, 10)
    }

    @Test
    fun testFindDupe5() {
        val input = Day06.readInput("./input/Day06e.txt")
        val idx = Day06.waitUntilDupe(input)
        assertEquals(idx, 11)
    }

    @Test
    fun testFindDupe6() {
        val input = Day06.readInput("./input/Day06f.txt")
        val idx = Day06.waitUntilDupe(input)
        assertEquals(idx, 1275)
    }

    @Test
    fun testFindDupe7() {
        val idx = Day06.waitUntilDupe("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 14)
        assertEquals(idx, 19)
    }

    @Test
    fun testFindDupe8() {
        val idx = Day06.waitUntilDupe("bvwbjplbgvbhsrlpgdmjqwftvncz", 14)
        assertEquals(idx, 23)
    }

    @Test
    fun testFindDupe9() {
        val idx = Day06.waitUntilDupe("nppdvjthqldpwncqszvftbrmjlhg", 14)
        assertEquals(idx, 23)
    }

    @Test
    fun testFindDupe10() {
        val idx = Day06.waitUntilDupe("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 14)
        assertEquals(idx, 29)
    }

    @Test
    fun testFindDupe11() {
        val idx = Day06.waitUntilDupe("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 14)
        assertEquals(idx, 26)
    }

    @Test
    fun testFindDupe12() {
        val input = Day06.readInput("./input/Day06f.txt")
        val idx = Day06.waitUntilDupe(input, 14)
        assertEquals(idx, 3605)
    }
}
import kotlin.test.*
class Day01Test {
    @Test
    fun testReadFile() {
        val result = Day01.readInput("./input/Day01a.txt")
        assertEquals(result.size, 5)
    }

    @Test
    fun testCountCalories1() {
        val result = Day01.readInput("./input/Day01a.txt")
        val calories = Day01.countCalories(result)
        val topCalories = Day01.topCalories(calories)
        assertEquals(topCalories, 24000)
    }

    @Test
    fun testCountCalories2() {
        val result = Day01.readInput("./input/Day01b.txt")
        val calories = Day01.countCalories(result)
        val topCalories = Day01.topCalories(calories)
        assertEquals(topCalories, 75501)
    }

    @Test
    fun testCountCalories3() {
        val result = Day01.readInput("./input/Day01a.txt")
        val calories = Day01.countCalories(result)
        val topCalories = Day01.top3Calories(calories)
        assertEquals(topCalories, 45000)
    }

    @Test
    fun testCountCalories4() {
        val result = Day01.readInput("./input/Day01b.txt")
        val calories = Day01.countCalories(result)
        val topCalories = Day01.top3Calories(calories)
        assertEquals(topCalories, 215594)
    }
}
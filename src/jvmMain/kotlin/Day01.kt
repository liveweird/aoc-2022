import java.io.InputStream
import java.io.File
class Day01 {
    companion object Part1 {
        fun readInput(fileName: String): MutableList<MutableList<Int>> {
            val inputStream: InputStream = File(fileName).inputStream()
            val result: MutableList<MutableList<Int>> = emptyList<MutableList<Int>>().toMutableList()
            var currentList = mutableListOf<Int>()

            inputStream.bufferedReader().useLines {
                lines -> lines.forEach {
                    line ->
                        run {
                            if (line.isEmpty()) {
                                // add collection to the list of collections
                                result.add(currentList)

                                // create a new collection
                                currentList = mutableListOf()
                            } else {
                            // add item to a current collection
                            currentList.add(line.toInt())
                        }
                    }
                }

                // when you're done add the last collection to the list of collections
                result.add(currentList)
            }

            return result
        }

        fun countCalories(calories: MutableList<MutableList<Int>>): List<Int> {
            val counted: List<Int> = calories
                .map {
                    list: List<Int> -> list.toList().sumOf { it }
                }

            return counted
        }

        fun topCalories(counted: List<Int>): Int {
            return counted.max()
        }

        fun top3Calories(counted: List<Int>): Int {
            return counted
                .sorted()
                .asReversed()
                .take(3)
                .sum()
        }
    }
}
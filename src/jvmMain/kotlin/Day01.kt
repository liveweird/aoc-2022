import java.io.InputStream
import java.io.File
class Day01 {
    companion object Part1 {
        fun readInput(fileName: String): MutableList<MutableList<Number>> {
            val inputStream: InputStream = File(fileName).inputStream()
            val result: MutableList<MutableList<Number>> = emptyList<MutableList<Number>>().toMutableList()
            var currentList = mutableListOf<Number>()

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
    }
}
import java.io.File
import java.io.InputStream
import kotlin.streams.toList

class Day06 {
    companion object Part1 {
        fun readInput(fileName: String): String {
            val inputStream: InputStream = File(fileName).inputStream()
            return inputStream.bufferedReader().readText()
        }

        fun waitUntilDupe(input: String, size: Int = 4): Int {
            val map = mutableMapOf<Char, Int>()
            val slice: ArrayDeque<Char> = ArrayDeque()

            // initialization
            slice.addAll(input.toCharArray().take(size))
            slice.forEach {
                elem: Char ->
                    map[elem] = map.getOrDefault(elem, 0) + 1
            }

            for (idx in size until input.length) {

                // decrease dropper
                val dropper = input[idx - size]
                map[dropper] = map[dropper]!! - 1
                slice.removeFirst()

                // increase popper
                val popper = input[idx]
                map[popper] = map.getOrDefault(popper, 0) + 1
                slice.addLast(popper)

                // check exit condition
                if (!map.any {
                        (_, v) -> v > 1
                    }) {
                    return idx + 1
                }
            }

            return input.length + 1
        }
    }
}
import java.io.File
import java.io.InputStream

class Day03 {

    companion object Part1 {
        fun readInput(fileName: String): MutableList<Pair<out CharSequence, out CharSequence>> {
            val inputStream: InputStream = File(fileName).inputStream()
            var result: MutableList<Pair<out CharSequence, out CharSequence>> = mutableListOf()

            inputStream.bufferedReader().useLines {
                    lines -> lines.forEach {
                    line ->
                    run {
                        val lineLength: Int = line.length
                        val left = line.subSequence(0, lineLength / 2)
                        val right = line.subSequence(lineLength / 2, lineLength)
                        result.add(Pair(left, right))
                    }
                }
            }

            return result
        }

        fun findDupes(pairs: MutableList<Pair<out CharSequence, out CharSequence>>): List<Char> {
            var result: List<Char> =
                pairs.map {
                    (left: CharSequence, right: CharSequence) ->
                        var leftSet: MutableSet<Char> = mutableSetOf()
                        left.forEach { character: Char -> leftSet.add(character) }
                        var rightSet: MutableSet<Char> = mutableSetOf()
                        right.forEach { character -> rightSet.add(character) }
                        leftSet.intersect(rightSet).first()
                }

            return result
        }

        fun calcPoints(dupes: List<Char>): Int {
            var result =
                dupes.map {
                    dupe ->
                        if (dupe == dupe.lowercase().first()) {
                            dupe.minus('a')+ 1
                        } else {
                            dupe.minus('A') + 27
                        }
                }
                .sum()

            return result
        }
    }
}
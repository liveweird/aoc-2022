import java.io.File
import java.io.InputStream

class Day04 {
    companion object Part1 {

        data class Range(val left: Int, val right: Int) {
            fun doesFullyContain(another: Range): Boolean {
                return this.left <= another.left &&
                        this.right >= another.right
            }

            fun isLeftOf(another: Range): Boolean {
                return this.right < another.left
            }
        }
        fun readInput(fileName: String): MutableList<Pair<Range, Range>> {
            val inputStream: InputStream = File(fileName).inputStream()
            val result: MutableList<Pair<Range, Range>> = mutableListOf()
            val regex = Regex("(\\d+)-(\\d+),(\\d+)-(\\d+)")

            inputStream.bufferedReader().useLines {
                lines -> lines.forEach {
                line ->
                    run {
                        val all = regex.matchEntire(line)!!.groupValues
                        val left = Range(all[1].toInt(), all[2].toInt())
                        val right = Range(all[3].toInt(), all[4].toInt())
                        result.add(Pair(left, right))
                    }
                }
            }

            return result
        }

        fun countPoints(pairs: MutableList<Pair<Range, Range>>): Int {
            val points = pairs.map {
                pair ->
                    if (pair.first.doesFullyContain(pair.second) ||
                        pair.second.doesFullyContain(pair.first)) 1
                    else 0
            }
                .sum()

            return points
        }

        fun countPoints2(pairs: MutableList<Pair<Range, Range>>): Int {
            val points = pairs.map {
                    pair ->
                if (pair.first.isLeftOf(pair.second) ||
                    pair.second.isLeftOf(pair.first)) 0
                else 1
            }
                .sum()

            return points
        }
    }
}
import java.io.File
import java.io.InputStream

class Day02 {
    companion object Part1 {

        enum class Winner {
            LEFT, DRAW, RIGHT
        }
        enum class Gesture {
            ROCK, PAPER, SCISSORS
        }
        data class Match(val left: Gesture, var right: Gesture) {
            private fun whoWins(): Winner {
                if (left == right) { return Winner.DRAW }
                if ((left == Gesture.ROCK && right == Gesture.SCISSORS) ||
                    (left == Gesture.PAPER && right == Gesture.ROCK) ||
                    (left == Gesture.SCISSORS && right == Gesture.PAPER)) {
                    return Winner.LEFT
                }
                return Winner.RIGHT
            }

            fun howManyPoints(): Int {
                val ingredientOne =
                    when (right) {
                        Gesture.ROCK -> 1
                        Gesture.PAPER -> 2
                        Gesture.SCISSORS -> 3
                    }

                val ingredientTwo =
                    when (whoWins()) {
                        Winner.LEFT -> 0
                        Winner.DRAW -> 3
                        Winner.RIGHT -> 6
                    }

                return ingredientOne + ingredientTwo
            }
        }

        fun readInput(fileName: String): MutableList<Match> {
            val inputStream: InputStream = File(fileName).inputStream()
            val result: MutableList<Match> = mutableListOf()
            val regex: Regex = Regex("([ABC]) ([XYZ])")

            inputStream.bufferedReader().useLines {
                lines -> lines.forEach {
                line ->
                    run {
                        val both = regex.matchEntire(line)!!.groupValues
                        val left: Gesture =
                            when (both[1]) {
                                "A" -> Gesture.ROCK
                                "B" -> Gesture.PAPER
                                else -> { Gesture.SCISSORS }
                            }

                        val right: Gesture =
                            when (both[2]) {
                                "X" -> Gesture.ROCK
                                "Y" -> Gesture.PAPER
                                else -> { Gesture.SCISSORS }
                            }

                        result.add(Match(left, right))
                    }
                }
            }

            return result
        }

        fun readInput2(fileName: String): MutableList<Match> {
            val inputStream: InputStream = File(fileName).inputStream()
            val result: MutableList<Match> = mutableListOf()
            val regex: Regex = Regex("([ABC]) ([XYZ])")

            inputStream.bufferedReader().useLines {
                lines -> lines.forEach {
                    line ->
                    run {
                        val both = regex.matchEntire(line)!!.groupValues
                        val left: Gesture =
                            when (both[1]) {
                                "A" -> Gesture.ROCK
                                "B" -> Gesture.PAPER
                                else -> { Gesture.SCISSORS }
                            }

                        val winner: Winner =
                            when (both[2]) {
                                "X" -> Winner.LEFT
                                "Y" -> Winner.DRAW
                                else -> Winner.RIGHT
                            }

                        val right: Gesture = if (winner == Winner.DRAW) {
                            left
                        } else if ((winner == Winner.LEFT && left == Gesture.SCISSORS) ||
                            (winner == Winner.RIGHT && left == Gesture.ROCK)) {
                            Gesture.PAPER
                        } else if ((winner == Winner.LEFT && left == Gesture.PAPER) ||
                            (winner == Winner.RIGHT && left == Gesture.SCISSORS)) {
                            Gesture.ROCK
                        } else {
                            Gesture.SCISSORS
                        }

                        result.add(Match(left, right))
                    }
                }
            }

            return result
        }

        fun countPoints(matches: MutableList<Match>): Int {
            val points = matches.sumOf { match: Match ->
                match.howManyPoints()
            }

            return points
        }
    }
}
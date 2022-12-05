import java.io.File
import java.io.InputStream

class Day05 {
    companion object Part1 {

        data class Command(val howMany: Int, val source: Int, val destination: Int) {
        }

        enum class ReadingMode {
            STACKS, COMMANDS
        }

        fun readInput(fileName: String, size: Int): Pair<List<ArrayDeque<Char>>, List<Command>> {
            val inputStream: InputStream = File(fileName).inputStream()
            val stacks: MutableList<ArrayDeque<Char>> = MutableList(size) { ArrayDeque() }
            val commands: MutableList<Command> = mutableListOf()

            val regexStacks = Regex("\\[(.)]")
            val regexCommands = Regex("move (\\d+) from (\\d+) to (\\d+)")
            var readingMode: ReadingMode = ReadingMode.STACKS

            inputStream.bufferedReader().useLines { lines ->
                lines.forEach { line ->
                    run {
                        when (readingMode) {
                            ReadingMode.STACKS -> {
                                if (line.isEmpty()) {
                                    readingMode = ReadingMode.COMMANDS
                                } else {
                                    val pieces = (line.length + 1) / 4
                                    for (index in 0 until pieces) {
                                        val toBeMatched = line.subSequence(index * 4, (index * 4) + 3)
                                        if (regexStacks.matches(toBeMatched)) {
                                            val item = line[(index * 4) + 1]
                                            (stacks.getOrElse(index) { ArrayDeque() }).addLast(item)
                                        }
                                    }
                                }
                            }

                            ReadingMode.COMMANDS -> {
                                val all = regexCommands.matchEntire(line)!!.groupValues
                                val command = Command(all[1].toInt(), all[2].toInt(), all[3].toInt())
                                commands.add(command)
                            }
                        }
                    }
                }
            }

            return Pair(stacks, commands)
        }

        fun process(stacks: List<ArrayDeque<Char>>, commands: List<Command>): List<Char> {
            var result: MutableList<Char> = mutableListOf()

            for (command in commands) {
                for (iter in 1 until (command.howMany+1)) {
                    // pick up item from source
                    val retrieved = stacks[command.source - 1].removeFirst()
                    // slap item to destination
                    (stacks.getOrElse(command.destination - 1) { ArrayDeque() }).addFirst(retrieved)
                }
            }

            for (stack in stacks) {
                result.add(stack.first())
            }

            return result
        }
    }
}
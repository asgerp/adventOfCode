package days

class DayTwo {

    fun solve() {
        val lines = this::class.java.getResourceAsStream("/input2.txt")?.bufferedReader()?.readLines()!!
        var points = 0
        for (l in lines) {
            val p = calcNewScore(l.substring(0, 1), l.substring(2, 3))
            points += p
            println("$p and ${l.substring(0, 1)}, ${l.substring(2, 3)}")
        }

        println(points)


    }

    private fun calcScore(elf: String, you: String): Int {
        var points = when (elf) {
            // rock
            "A" -> {
                when (you) {
                    "X" -> 3
                    "Y" -> 6
                    "Z" -> 0
                    else -> {
                        0
                    }
                }
            }
            // paper
            "B" -> {
                when (you) {
                    "X" -> 0
                    "Y" -> 3
                    "Z" -> 6
                    else -> {
                        0
                    }
                }
            }
            // scissors
            "C" -> {
                when (you) {
                    "X" -> 6
                    "Y" -> 0
                    "Z" -> 3
                    else -> {
                        0
                    }
                }
            }
            else -> {
                0
            }
        }

        points += when (you) {
            "X" -> 1 // rock
            "Y" -> 2 // paper
            "Z" -> 3 // scissor
            else -> {
                0
            }
        }

        return points
    }

    private fun calcNewScore(elf: String, you: String): Int {
        var points = when (you) {
            "X" -> 0 // loss
            "Y" -> 3 // draw
            "Z" -> 6 // win
            else -> {
                0
            }
        }
        
        points += when (elf) {
            // rock
            "A" -> {
                when (you) {
                    "X" -> 3 // loss -> scissor
                    "Y" -> 1 // draw -> rock
                    "Z" -> 2 // win -> paper
                    else -> {
                        0
                    }
                }
            }
            // paper
            "B" -> {
                when (you) {
                    "X" -> 1 // loss -> rock
                    "Y" -> 2 // draw -> paper
                    "Z" -> 3 // win -> scissor
                    else -> {
                        0
                    }
                }
            }
            // scissors
            "C" -> {
                when (you) {
                    "X" -> 2 // loss -> paper
                    "Y" -> 3 // draw -> scissor
                    "Z" -> 1 // win -> rock
                    else -> {
                        0
                    }
                }
            }
            else -> {
                0
            }
        }

        return points
    }
}
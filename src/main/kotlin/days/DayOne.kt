package days


class DayOne {



    fun solve() {
        val lines = this::class.java.getResourceAsStream("/input1.txt")?.bufferedReader()?.readLines()
        val cals = mutableListOf<Int>()
        var currentCal = 0
        if (lines != null) {
            for (l in lines) {
                if (l.isBlank()) {
                    cals.add(currentCal)
                    currentCal = 0
                } else {
                    currentCal += l.toInt()
                }

            }
        }
        println(cals.max())
        println(cals.sortedDescending().take(3).sum())
    }
}


import java.io.File

fun main() {
    val input = "./input/day-02-0.txt"
    val commands = File(input).readLines().map { it.split(' ') }

    // Part 1
    run {
        val h = commands.filter { it[0] == "forward" }.sumOf { it[1].toInt() }
        val d = commands.filter { it[0] == "down" }.sumOf { it[1].toInt() } - commands.filter { it[0] == "up" }
            .sumOf { it[1].toInt() }
        val ans_1 = h * d
        println("ans_1: $ans_1")
    }

    // Part 2
    run {
        var a = 0
        var d = 0
        var h = 0;
        for (c in commands) {
            when (c[0]) {
                "forward" -> {
                    h += c[1].toInt()
                    d += a * c[1].toInt()
                }
                "down" -> a += c[1].toInt()
                "up" -> a -= c[1].toInt()
            }
        }
        val ans_2 = h * d
        println("ans_2: $ans_2")
    }
}
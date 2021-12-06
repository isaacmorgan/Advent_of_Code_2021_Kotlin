import java.io.File

fun main() {
    val input = "./input/day-01-0.txt"
    val depth = File(input).readLines().map { it.toInt() }

    // Part 1
    var ans_1 = depth.zip(depth.drop(1)).count { it.first < it.second }
    println("ans_1: $ans_1")

    // Part 2
    var ans_2 = depth.zip(depth.drop(3)).count { it.first < it.second }
    println("ans_2: $ans_2")
}
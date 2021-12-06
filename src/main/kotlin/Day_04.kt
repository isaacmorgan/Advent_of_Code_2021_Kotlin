import java.io.File

fun main() {
    val input = "./input/day-04-0.txt"
    val lines = File(input).readLines()
    val board = lines[0].split(',').map { it.toInt() }
    val cards = (1..lines.size-1 step 6).map {
        n -> (1..5).flatMap { lines[n+it].trim().split(Regex("\\s+")) }.map { it.toInt() }
    }
    val stamps = cards.map { mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ) }

    val rank_score = cards.zip(stamps).map { x ->
        for ((i, ball) in board.withIndex()) {
            for ((ind, num) in x.first.withIndex()) {
                if (num == ball) {
                   x.second[ind] = 1
                   break
                }
            }
            if (check(x.second)) {
                return@map Pair(i, score(x.first, x.second, ball))
            }
        }
        return@map Pair(-1, -1)
    }

    val min = rank_score.map{ p -> p.first }.minOrNull()
    val max = rank_score.map{ p -> p.first }.maxOrNull()
    val ans_1 = rank_score.filter { it.first == min }.map { it.second }[0]
    val ans_2 = rank_score.filter { it.first == max }.map { it.second }[0]

    println("ans_1: $ans_1")
    println("ans_2: $ans_2")
}

fun score(card: List<Int>, stamp: List<Int>, ball: Int): Int {
    return ball*stamp.zip(card) { s, c -> if (s == 0) c else 0 }.sum()
}

fun check(stamp: List<Int>): Boolean {
    // horizontal and vertical
    return (0..4).any { r -> (0..4).count { c -> stamp[5*r + c] == 1 } == 5 }
            || (0..4).any { c -> (0..4).count { r -> stamp[5*r + c] == 1 } == 5 }
}

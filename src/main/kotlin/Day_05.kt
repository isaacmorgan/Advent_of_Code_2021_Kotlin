import java.io.File

fun main() {
    val input = "./input/day-05-0.txt"
    val data = File(input).readLines().map { it.split(Regex("[^\\d]+")).map { it.toInt() } }

    var map = HashMap<Pair<Int, Int>, Int>()

    // Part 1
    for (d in data) {
        val x0 = d[0];
        val y0 = d[1];
        val x1 = d[2];
        val y1 = d[3];

        if (x0 == x1) {
            if (y0 <= y1) {
                (y0..y1).forEach { map[Pair(x0, it)] = map.getOrDefault(Pair(x0, it), 0) + 1 }
            } else {
                (y1..y0).forEach { map[Pair(x0, it)] = map.getOrDefault(Pair(x0, it), 0) + 1 }
            }
        } else if (y0 == y1) {
            if (x0 <= x1) {
                (x0..x1).forEach { map[Pair(it, y0)] = map.getOrDefault(Pair(it, y0), 0) + 1 }
            } else {
                (x1..x0).forEach { map[Pair(it, y0)] = map.getOrDefault(Pair(it, y0), 0) + 1 }
            }
        }
    }
    val ans_1 = map.count { it.value > 1 }

    println("ans_1: $ans_1")

    // Part 2

    for (d in data) {
        val x0 = d[0];
        val y0 = d[1];
        val x1 = d[2];
        val y1 = d[3];

        if (x0 != x1 && y0 != y1) {
            val dx = if (x1 > x0) 1 else -1
            val dy = if (y1 > y0) 1 else -1
            for (i in 0..dx*(x1-x0)) {
                val x = x0 + i*dx
                val y = y0 + i*dy
                map[Pair(x,y)] = map.getOrDefault(Pair(x,y), 0) + 1
            }
        }
    }
    val ans_2 = map.count { it.value > 1 }

    println("ans_2: $ans_2")
}
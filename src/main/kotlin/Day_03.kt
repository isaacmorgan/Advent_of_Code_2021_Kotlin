import java.io.File
import kotlin.math.pow

fun main() {
    val input = "./input/day-03-0.txt"
    val text = File(input).readLines()
    val n = 12

    // Part 1
    run {
        var mcb = (0..(n-1)).map {
                b -> if (text.count { it[b] == '1' } > text.count()/2) "1" else "0"
        }.joinToString(separator = "")
        val gamma = Integer.parseInt(mcb, 2)
        val epsilon = 2.0.pow(n) - 1 - gamma
        val ans_1 = gamma * epsilon;
        println("ans_1: $ans_1")
    }

    // Part 2
    var list = text;
    var mcb = (0..(n-1)).forEach {
            b -> if (list.count { it[b] == '1' } >= list.count()/2.0) {
        list = list.filter { x -> x[b] == '1' }
    } else {
        list = list.filter { x -> x[b] == '0' }
    }
    }
    val oxy = Integer.parseInt(list[0], 2)

    list = text
    var lcb = (0..(n-1)).forEach {
            b -> if (list.size > 1) {
        if (list.count { it[b] == '0' } > list.count()/2.0) {
            list = list.filter { x -> x[b] == '1' }
        } else {
            list = list.filter { x -> x[b] == '0' }
        }
    }
    }
    val co2 = Integer.parseInt(list[0], 2)

    val ans_2 = oxy * co2;
    println("ans_2: $ans_2")
}
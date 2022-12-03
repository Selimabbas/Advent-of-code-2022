package day02

import java.io.File

fun main() {
    File("src/main/kotlin/day02/input.txt")
        .readLines()
        .sumOf {
            val opponent = it[0].code - 64
            val result = it[2]

            val (choice, resultValue) = when (result) {
                'Y' -> opponent to 3
                'X' -> (opponent - 1).let { if (it == 0) 3 else it } to 0
                'Z' -> (opponent + 1).let { if (it == 4) 1 else it } to 6
                else -> throw Exception()
            }
            resultValue + choice
        }.let { println(it) }
}
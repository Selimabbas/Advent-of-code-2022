package day02

import java.io.File

fun main() {
    File("src/main/kotlin/day02/input.txt")
        .readLines()
        .sumOf {
            val opponent = it[0] - 64
            val choice = it[2] - 87
            val result : Int = when (choice - opponent) {
                -2 -> 6
                -1 -> 0
                0 -> 3
                1 -> 6
                2 -> 0
                else -> throw Exception()
            }
            result + choice.code
        }.let { println(it) }
}

fun String.replaceWithNumbers() = this.map {
    when (it) {
        'A', 'X'-> '1'
        'B', 'Y' -> '2'
        'C', 'Z' -> '3'
        else -> it
    }
}
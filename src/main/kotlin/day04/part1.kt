package day04

import java.io.File

fun main() {
    var pairs = 0
    File("src/main/kotlin/day04/input.txt")
        .readLines()
        .map { line ->
            line.split(',')
                .map { it.split('-').map { number -> number.toInt() } }
        }
        .forEach {
            if ((it[0][0] <= it[1][0] && it[0][1] >= it[1][1])
                || it[0][0] >= it[1][0] && it[0][1] <= it[1][1]
            ) pairs++
        }
    println(pairs)
}
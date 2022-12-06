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
        .forEach loop@{
            (it[0][0]..it[0][1]).forEach { value ->
                if ((it[1][0]..it[1][1]).contains(value)) {
                    pairs++
                    return@loop
                }
            }
        }
    println(pairs)
}
package day01

import java.io.File

fun main() {
    File("src/main/kotlin/day01/input.txt")
        .readText()
        .split("\n\n")
        .map {
            it.split("\n").sumOf { calories -> calories.toInt() }
        }.sorted()
        .takeLast(3)
        .sum()
        .let { println(it) }
}
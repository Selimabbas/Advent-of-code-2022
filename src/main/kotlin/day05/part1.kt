package day05

import java.io.File

fun main() {
    val (crates, instructions) = File("src/main/kotlin/day05/input.txt")
        .readText()
        .split(" 1   2   3   4   5   6   7   8   9\n\n")
        .let { line ->
            val array = Array(9) { mutableListOf<Char>() }
            line[0].split("\n").forEach {
                it.forEachIndexed { i, char ->
                    if (char in 'A'..'Z') array[(i - 1) / 4].add(char)
                }
            }
            Pair(array, line[1].split("\n")
                .map { instructions ->
                    instructions.removePrefix("move ")
                        .split(" from ")
                        .flatMap { it.split(" to ") }
                }.map { Move(it[0].toInt(), it[1].toInt(), it[2].toInt()) })
        }

    instructions.forEach { move ->
        repeat(move.number) {
            crates[move.end - 1].add(0, crates[move.start - 1].removeFirst())
        }
    }
    crates.forEach { print(it.first()) }
}

data class Move(val number: Int, val start: Int, val end: Int)
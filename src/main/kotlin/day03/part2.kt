package day03

import java.io.File

fun main() {
    File("src/main/kotlin/day03/input.txt")
        .readLines()
        .chunked(3)
        .map { elf ->
            elf[0].forEach {
                if (elf[1].contains(it) && elf[2].contains(it)) {
                    return@map when (it) {
                        in 'a'..'z' -> it.code - 96
                        in 'A'..'Z' -> it.code - 38
                        else -> throw Exception()
                    }
                }
            }
            throw Exception()
        }.sum()
        .let { println(it) }
}
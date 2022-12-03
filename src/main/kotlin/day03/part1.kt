package day03

import java.io.File

fun main() {
    var total = 0
    File("src/main/kotlin/day03/input.txt")
        .readLines()
        .map { it.substring(0 until (it.length / 2)) to it.substring((it.length / 2) until it.length) }
        .forEach { compartments ->
            (('a'..'z') + ('A'..'Z')).forEach {
                if (compartments.first.contains(it) && compartments.second.contains(it)) {
                    total += when (it) {
                        in 'a'..'z' -> it.code - 96
                        in 'A'..'Z' -> it.code - 38
                        else -> throw Exception()
                    }
                }
            }
        }
    println(total)
}
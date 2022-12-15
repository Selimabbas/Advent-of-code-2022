package day06

import java.io.File

fun main() {
    File("src/main/kotlin/day06/input.txt")
        .readLines()
        .forEach {
            for (i in it.indices) {
                val end = i + 13
                val substring = it.substring(i..end).toCharArray()
                println("${it.substring(i..end)} / ${substring.distinct()}")
                if (substring.size == substring.distinct().size) {
                    println(end + 1)
                    return
                }
            }
        }
}


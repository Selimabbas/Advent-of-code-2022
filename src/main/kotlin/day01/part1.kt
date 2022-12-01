package day01

import java.io.File

fun main() {
    var maxCalories = 0
    File("src/main/kotlin/day01/input.txt")
        .readText()
        .split("\n\n")
        .forEach {
            it.split("\n")
                .sumOf { calories -> calories.toInt() }
                .let { caloriesSum ->
                    if (caloriesSum > maxCalories) maxCalories = caloriesSum
                }
        }
    println(maxCalories)
}
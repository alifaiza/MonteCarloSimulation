package com.vocalabs.age

/**
 * Simple CSV front-end for IntelliJ.
 */

fun main(args: Array<String>) {
    val   startYear = 2000
    val generations = 7
    val    consumer = CsvPersonConsumer()
    Simulator(startYear, generations, consumer)
            .run()
}
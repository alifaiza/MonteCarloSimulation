package com.vocalabs.age

import com.vocalabs.util.histogram

/**
 * Prints Histogram to standard out.
 */
class HistogramPersonConsumer (val denominator: Double) : PersonConsumer {
    var currentGeneration = 0
    override fun read(peopleInGeneration: List<Person>) {
        currentGeneration++
        println("\n\n----- Generation $currentGeneration ----")
        val datesOfBirth: List<Int> = peopleInGeneration.map { it.dateOfBirth }
        println(histogram(datesOfBirth, denominator))

    }


}
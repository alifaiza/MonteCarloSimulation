package com.vocalabs.age
import com.vocalabs.util.countDuplicates
/**
 * Prints CSV to standard out.
 */
class CsvPersonConsumer : PersonConsumer {
    override fun read(people: List<Person>) {
        val personOrNull = people.firstOrNull() ?: return
        val generation : Int = personOrNull.generation
        val dates = people.map { it.dateOfBirth }
        val counts = countDuplicates(dates)
        counts.forEach { year, count ->
            println("$generation,$year,${counts[year]}")
        }
}
    override fun start() {
        println("generation, dob, count")
    }
}
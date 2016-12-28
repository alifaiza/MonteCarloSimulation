package com.vocalabs.age

/**
 * Reads output from the simulation.
 */
interface PersonConsumer {
    /** read takes a single generation and each generation must be given in the correct order  */
    fun read(people: List<Person>)
    fun start() {}
    fun end() {}
}
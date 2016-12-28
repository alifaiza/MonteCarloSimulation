package com.vocalabs.age

interface SimulationRun {

    fun runGeneration(previousGeneration: Iterable<Person>): List<Person>

    /** Return a map of generations to a count of each person per year. I.e. Map(generation) -> Map(year) -> count. */
    fun runSimulation(simulator: Simulator): Map<Int, List<Person>>
}

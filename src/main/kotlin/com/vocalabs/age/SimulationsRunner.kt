package com.vocalabs.age

import com.vocalabs.util.histogram
import java.util.*

/*
/** Runs a Simulator and merges the results of each. */
class SimulationsRunner(simulator: Simulator) : SimulationRun {

    val random = Random()
    override fun runGeneration(previousGeneration: Iterable<Person>): List<Person> {
        val newGeneration = previousGeneration.flatMap {
            it.giveBirth(
                    it.calculateNumberOfChildren(random.nextGaussian()),
                    it.ageOfFirstBirth(random.nextGaussian()))
        }
       return newGeneration
    }

    override fun runSimulation(parent: Person, numberOfGens: Int, outputForm: String): TreeMap<Int, List<Person>> {
        // The list 'temp' will store only the new generations born in order to be used
        //    for giving birth to the generations after them
        var temp = listOf(parent)
        // The treeMap 'generationsMap' is the one all generations are stored
        var generationsMap = TreeMap<Int, List<Person>>()

        val random = Random()
        // for loop to run each simulation as many times as the number of generations specified
        for (j in 0..(numberOfGens.toInt()) - 1) {
            temp = temp.flatMap {
                it.giveBirth(
                        it.calculateNumberOfChildren(random.nextGaussian()),
                        it.ageOfFirstBirth(random.nextGaussian()))
            }
            // adding the generations to the map
            var listOfYears = mutableListOf<Person>()
            for (k in 0..temp.size - 1) {
                listOfYears.add(temp[k])
                generationsMap.put(j, listOfYears)
            }
        }
        return generationsMap
    }

    /**
     * Run multiple simulations and return a map of generations to a count of each
     * person per year. I.e. Map(generation) -> people.
     */
    fun run(numberOfSimulations: Int): TreeMap<Int, List<Person>> {
        // *** Output format for each generation ***
        println("\n\n********** SIMULATION $i **********")
        println("*** Parent from generation 0 with year of birth: " + parent.dateOfBirth)
        for (m in 0..generationsMap.size - 1) {
            println("Generation: " + (m + 1) + " years of births: " + generationsMap.get(m))
        }
        // Print as 'csv'
        if (outputForm == "csv") {
            val lines: List<String> = generationsMap.map { "${it.key + 1}, ${it.value}" }
            println("generation,dateOfBirth \n${lines.joinToString(separator = "\n")}\n\n")
        }
        // Print as a histogram
        else if (outputForm == "histogram") {
            for (p in 0..numberOfGens.toInt() - 1) {
                val peopleInGeneration = generationsMap.filter { it.key == p }
                println("\n\n----- Generation ${p + 1} ----")
                val datesOfBirth: List<Int> = peopleInGeneration.flatMap { it.value }
                println(histogram(datesOfBirth) + "\n\n\n")
            }
        }
    }
}
        */
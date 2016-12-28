package com.vocalabs.age
import java.util.*

class Simulator(val yearOfBirthInt: Int, val numberOfGens: Int, val consumer: PersonConsumer) {

    fun run(): TreeMap<Int, List<Person>> {
        val random = Random()
        val parent = Person (0, yearOfBirthInt)
        var currentGeneration = listOf(parent)
        var generationMap = TreeMap<Int, List<Person>>()
        for (i in 0..(numberOfGens.toInt() - 1)) {
            currentGeneration = currentGeneration.flatMap {
                it.giveBirth(
                        it.calculateNumberOfChildren(random.nextGaussian()),
                        it.ageOfFirstBirth(random))
            }
            generationMap.put(i, currentGeneration)
        }
       return generationMap
    }

    fun write(runResult: TreeMap<Int, List<Person>>) {
        consumer.start()
        runResult.forEach { generation, people -> consumer.read(people) }
        consumer.end()
    }
}
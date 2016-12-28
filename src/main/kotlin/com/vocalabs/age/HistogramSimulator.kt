package com.vocalabs.age

/**
 * Simple histogram front-end for IntelliJ.
 */

fun main(args: Array<String>) {
    val   startYear = 1972
    val generations = 7
    val numberOfGenerations = 1000
    val    consumer = HistogramPersonConsumer(numberOfGenerations.toDouble())
    val mySimulator = Simulator(startYear, generations, consumer)

    val simulationResult = SimulationsRunner(mySimulator).run(numberOfGenerations)
    mySimulator.write(simulationResult)
}
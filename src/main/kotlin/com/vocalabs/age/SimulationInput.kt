package com.vocalabs.age

/**
 * Generates needed input - initial parent, number of generations, number of simulations
 */
class SimulationInput : GenerateInput{

    override fun generateParent(): Person {
        println("Give parent's year of birth")
        val yearOfBirth = readLine()
        val yearOfBirthInt: Int
        if (yearOfBirth is String && yearOfBirth.toInt() is Int) {
            yearOfBirthInt = yearOfBirth.toInt()
        } else {
            throw IllegalArgumentException()
        }

        // Creates a the initial person (parent) with the given YOB
        return Person (0, yearOfBirthInt)
    }
    override fun returnNumOfSimulations() : Int {
        // Getting the number of simulations to run as user input
        println("How many simulations do you want to run?")
        val numberOfSimulations = readLine()
        return when {
            numberOfSimulations is String -> numberOfSimulations.toInt()
            else     -> throw IllegalArgumentException()
        }
    }

    override fun returnNumOfGenerations(): Int {
        // Getting the number of generations as user input and those generations are spawned
        println("How many generations per simulation do you want?")
        val numberOfGens = readLine()
        return when {
            numberOfGens is String -> numberOfGens.toInt()
            else -> throw IllegalArgumentException()
        }
    }

    override fun returnOutputForm(): String {

        // Asking for output form as user input
        println("Choose an output form: 'csv' or 'histogram'")
        val outputForm = readLine()
        return when {
            outputForm == "csv" -> "csv"
            outputForm == "histogram" -> "histogram"
            else -> throw IllegalArgumentException()
        }
    }
}
package com.vocalabs.age
import java.lang.Math
import java.util.*

/**
 * Models human reproduction
 */
data class Person(val generation: Int, var dateOfBirth: Int) {

    fun willGiveBirth (chance: Double): Boolean = chance > 0.47

    fun ageOfFirstBirth (rand: Random): Int {
        val age = Math.round(rand.nextGaussian() * 12 + 27).toInt()
        return when {
            age < 15 -> ageOfFirstBirth(rand)
            age > 70 -> ageOfFirstBirth(rand)
            else     -> age
        }
    }

    fun yearOfFirstBirth (dateOfBirth: Int, firstBirthAt: Int): Int {
        return dateOfBirth + firstBirthAt
    }

    fun calculateNumberOfChildren(gaussianDouble: Double): Int {
        val numOfChildren = 0
        val gaussian = gaussianDouble * 1 + 2.5
        if (gaussian in 0.0..5.0) {
            return Math.round(gaussian).toInt()
        }
        return numOfChildren
    }

    fun giveBirth (numberOfKids: Int, firstBirthAge: Int): kotlin.collections.MutableList<Person> {
        var newGeneration = mutableListOf<Person>()
            for (i in 1..numberOfKids) {
                val child = Person(this.generation + 1, firstBirthAge)
                when (i) {
                    1 -> child.dateOfBirth = yearOfFirstBirth(dateOfBirth, firstBirthAge)
                    2 -> child.dateOfBirth = yearOfFirstBirth(dateOfBirth, firstBirthAge) + 3
                    3 -> child.dateOfBirth = yearOfFirstBirth(dateOfBirth, firstBirthAge) + 4
                    4 -> child.dateOfBirth = yearOfFirstBirth(dateOfBirth, firstBirthAge) + 5
                    5 -> child.dateOfBirth = yearOfFirstBirth(dateOfBirth, firstBirthAge) + 8
                }
                newGeneration.add(child)
            }
        return newGeneration
    }


}
package com.vocalabs.age

import org.junit.Test
import java.util.Random

import org.junit.Assert.*


class NewPersonTest {
    val random = Random()

    val personTester = Person(1, 2000)
    var firstBirth = random.nextInt(35)+15

    @Test
    fun willGiveBirth() {
        // willGiveBirth returns true for any value larger than 0.47
        assertTrue(personTester.willGiveBirth(0.48))
        assertTrue(personTester.willGiveBirth(1.0))
        assertTrue(personTester.willGiveBirth(0.67))
        // willGiveBirth returns false fr any value smaller than or equal to 0.47
        assertFalse(personTester.willGiveBirth(0.0))
        assertFalse(personTester.willGiveBirth(0.47))
        assertFalse(personTester.willGiveBirth(0.46))
        assertFalse(personTester.willGiveBirth(0.24))
    }

    @Test
    fun ageOfFirstBirth() {
        fail("Need to update for new behavior") /*
        // calculates the age of first birth the formula and compares it to the number returned by the function
        assertEquals(Math.round(-1.0 * 12 + 27).toInt(), personTester.ageOfFirstBirth(MockRandom(- 1.0)))
        assertEquals(Math.round(1.0 * 12 + 27).toInt(), personTester.ageOfFirstBirth(MockRandom(1.0)))
        assertEquals(Math.round(0.0 * 12 + 27).toInt(), personTester.ageOfFirstBirth(MockRandom(0.0)))
        //assertEquals(Math.round(Double.NEGATIVE_INFINITY * 12 + 27).toInt(),
        //        personTester.ageOfFirstBirth(Double.NEGATIVE_INFINITY))
        //assertEquals(Math.round(Double.POSITIVE_INFINITY * 12 + 27).toInt(),
        //        personTester.ageOfFirstBirth(Double.POSITIVE_INFINITY))
        */
    }

    @Test
    fun calculateNumberOfChildren() {
        // the gaussian random number given as parameter is added to 2.5 by formula
        // thus, any argument passed that is less than -2.5 or larger than 2.5 will give 0
        assertEquals(0, personTester.calculateNumberOfChildren(-2.6))
        assertEquals(0, personTester.calculateNumberOfChildren(2.6))
        // any other gaussian value passed, will be used for calculations using the formula
        assertEquals(Math.round(2.5 - 2.326547).toInt(), personTester.calculateNumberOfChildren(-2.356547))
        assertEquals(Math.round(2.5 + 2.42475).toInt(), personTester.calculateNumberOfChildren(2.42475))
        assertEquals(Math.round(2.5 - 1.726547).toInt(), personTester.calculateNumberOfChildren(-1.756547))
        assertEquals(Math.round(2.5 + 1.82475).toInt(), personTester.calculateNumberOfChildren(1.82475))
    }

    @Test
    fun giveBirth() {
        // number of children less than or equal to 0 or larger than 5 will produce 0 kids
        // any other number of kids x, will produce will produce x kids
        assertEquals(0, personTester.giveBirth(-1, 30).size)
        assertEquals(0, personTester.giveBirth(6, 26).size)
        assertEquals(0, personTester.giveBirth(6, 49).size)
        assertEquals(3, personTester.giveBirth(3, 32).size)

        // each kid from the following generation will be generation 2 as the tester person is generation 1
        assertEquals(2, personTester.giveBirth(5, firstBirth)[0].generation)
        assertEquals(2, personTester.giveBirth(5, firstBirth)[1].generation)
        assertEquals(2, personTester.giveBirth(5, firstBirth)[2].generation)
        assertEquals(2, personTester.giveBirth(5, firstBirth)[3].generation)
        assertEquals(2, personTester.giveBirth(5, firstBirth)[4].generation)

        // the dob of the first kid will be the same as the calculated value for firstBirth

        assertEquals(personTester.dateOfBirth + 35, personTester.giveBirth(1,35)[0].dateOfBirth)
        assertEquals(personTester.dateOfBirth + 65, personTester.giveBirth(5,65)[0].dateOfBirth)

        // dob of second kid will be 3 years after the firstBirth
        assertEquals(personTester.dateOfBirth + 22 + 3, personTester.giveBirth(2,22)[1].dateOfBirth)

        // dob of the third kid will be 4 years after the firstBirth
        assertEquals(personTester.dateOfBirth + 30 + 4, personTester.giveBirth(3,30)[2].dateOfBirth)

        // dob of the fourth kid will be 5 years after the firstBirth
        assertEquals(personTester.dateOfBirth + 24 + 5, personTester.giveBirth(4,24)[3].dateOfBirth)

        firstBirth = random.nextInt(35)+15
        assertEquals(personTester.dateOfBirth + 15 + 8, personTester.giveBirth(5,15)[4].dateOfBirth)
    }
}

class MockRandom(val gaussian1: Double, val gaussian2: Double = 0.0): Random() {
    var first: Boolean = true
    override fun nextGaussian(): Double {
        if (first) {
            first = false
            return gaussian1
        }
        else
            return gaussian2
    }
}

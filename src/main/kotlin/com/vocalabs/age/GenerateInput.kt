package com.vocalabs.age


interface GenerateInput {

    fun generateParent() : Person

    fun returnNumOfGenerations(): Int

    fun returnNumOfSimulations() : Int

    fun returnOutputForm() : String
}
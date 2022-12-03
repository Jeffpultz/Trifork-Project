package com.example.triforkAssigment.triforkAssignment.datasource

import com.example.triforkAssigment.triforkAssignment.model.Person

interface PersonDataSource {

    fun retrievePersons(): Collection<Person>
    fun retrievePerson(cpr: String): Person
    fun addPerson(person: Person): Person
    fun updatePerson(person: Person): Person
    fun deletePerson(cpr: String)
}
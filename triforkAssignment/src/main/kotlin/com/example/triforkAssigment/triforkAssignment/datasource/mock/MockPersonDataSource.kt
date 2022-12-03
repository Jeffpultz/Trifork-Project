package com.example.triforkAssigment.triforkAssignment.datasource.mock

import com.example.triforkAssigment.triforkAssignment.datasource.PersonDataSource
import com.example.triforkAssigment.triforkAssignment.model.Person
import org.springframework.stereotype.Repository


@Repository("mock")
class MockPersonDataSource : PersonDataSource {

    val persons = mutableListOf(
        Person("8974390231", "Fake Person Joe", "O-", 30),
        Person("2803945565", "Test Subject Doe", "AB", 22),
        Person("1104905685", "Last Person Jane", "O-", 30)
    )

    override fun retrievePersons(): Collection<Person> = persons

    override fun retrievePerson(cpr: String): Person = persons.firstOrNull { it.cpr == cpr } ?: throw NoSuchElementException("Could not find a person with CPR: $cpr ")

    override fun addPerson(person: Person): Person {
        if(persons.any { it.cpr == person.cpr }) {
            throw IllegalArgumentException("Person with CPR: ${person.cpr} already exists.")
        }
        persons.add(person)

        return person
    }

    override fun updatePerson(person: Person): Person {
        val currentPerson = persons.firstOrNull { it.cpr == person.cpr } ?: throw NoSuchElementException("Could not find a person with CPR: ${person.cpr}")

        persons.remove(currentPerson)
        persons.add(person)

        return person
    }

    override fun deletePerson(cpr: String) {
        val currentPerson = persons.firstOrNull { it.cpr == cpr } ?: throw NoSuchElementException("Could not find a persons ith CPR: $cpr")

        persons.remove(currentPerson)

    }
}
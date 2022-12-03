package com.example.triforkAssigment.triforkAssignment.service

import com.example.triforkAssigment.triforkAssignment.datasource.PersonDataSource
import com.example.triforkAssigment.triforkAssignment.model.Person
import org.springframework.stereotype.Service

@Service
class PersonService(private val dataSource: PersonDataSource) {

    fun getPersons(): Collection<Person> = dataSource.retrievePersons()
    fun getPerson(CPR: String): Person = dataSource.retrievePerson(CPR)
    fun addPerson(person: Person): Person = dataSource.addPerson(person)
    fun updatePerson(person: Person): Person = dataSource.updatePerson(person)
    fun deletePerson(CPR: String) = dataSource.deletePerson(CPR)

}
package com.example.triforkAssigment.triforkAssignment.service

import com.example.triforkAssigment.triforkAssignment.model.Person
import org.springframework.stereotype.Service
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.web.client.HttpServerErrorException.InternalServerError


@Service
class PersonServiceWithDB(private val db: JdbcTemplate) {

    fun getPersons(): Collection<Person> = db.query("SELECT * FROM person") { response, _ ->
        Person(response.getString("cpr"), response.getString("name"), response.getString("blood_type"),
        response.getInt("age"))
    }

    fun getPerson(CPR: String): Collection<Person> = db.query("SELECT * FROM person WHERE cpr = ?", CPR) { response, _ ->
        Person(response.getString("cpr"), response.getString("name"), response.getString("blood_type"),
            response.getInt("age"))
    }


    fun addPerson(person: Person): Person{
        val personList: Collection<Person> = getPersons()

        val exist: Boolean = personList.any{ it.cpr == person.cpr }

        if(exist){
            throw IllegalArgumentException("Person with CPR ${person.cpr} already exists.")
        }

        db.update("INSERT INTO person values ( ?, ?, ?, ?)",
            person.cpr, person.name, person.blood_type, person.age)

        return person
    }

    fun updatePerson(person: Person): Person{
        val currentPerson: Collection<Person> = getPerson(person.cpr)

        if(currentPerson.isEmpty()){
            throw NoSuchElementException("Person with CPR ${person.cpr} does not exists")
        }

        db.update("UPDATE person SET name=?, blood_type=?, age=? WHERE cpr = ?", person.name, person.blood_type, person.age, person.cpr)

        return person
    }

    fun deletePerson(CPR: String) {
        val currentPerson: Collection<Person> = getPerson(CPR)

        if (currentPerson.isEmpty()){
            throw NoSuchElementException("Person with CPR $CPR does not exists.")
        }

        db.update("DELETE FROM person WHERE cpr = ?", CPR)
    }


}
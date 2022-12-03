package com.example.triforkAssigment.triforkAssignment.controller

import com.example.triforkAssigment.triforkAssignment.model.Person
import com.example.triforkAssigment.triforkAssignment.service.PersonServiceWithDB
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpServerErrorException.InternalServerError

@CrossOrigin
@RestController
@RequestMapping("api/persons")
class PersonControllerWithDB (private val service: PersonServiceWithDB) {

    @ExceptionHandler(InternalServerError::class)
    fun handleInternalServerError(e: InternalServerError): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.INTERNAL_SERVER_ERROR)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.BAD_REQUEST)


    @GetMapping
    fun getPersons(): Collection<Person> = service.getPersons()

    @GetMapping("/{CPR}")
    fun getPerson(@PathVariable CPR: String): Collection<Person> = service.getPerson(CPR)

    @PatchMapping
    fun updatePerson(@RequestBody person: Person): Person = service.updatePerson(person)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addPerson(@RequestBody person: Person): Person = service.addPerson(person)

    @DeleteMapping("/{CPR}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePerson(@PathVariable CPR: String) = service.deletePerson(CPR)
}
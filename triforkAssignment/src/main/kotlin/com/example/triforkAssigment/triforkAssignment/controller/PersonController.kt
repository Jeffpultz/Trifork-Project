package com.example.triforkAssigment.triforkAssignment.controller

import com.example.triforkAssigment.triforkAssignment.model.Person
import com.example.triforkAssigment.triforkAssignment.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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


@RestController
//@RequestMapping("api/persons")
class PersonController (private val service: PersonService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping
    fun getPersons(): Collection<Person> = service.getPersons()

    @GetMapping("/{CPR}")
    fun getPerson(@PathVariable CPR: String) = service.getPerson(CPR)

    @PatchMapping
    fun updateBank(@RequestBody person: Person): Person = service.updatePerson(person)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addPerson(@RequestBody person: Person): Person = service.addPerson(person)

    @DeleteMapping("/{CPR}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePerson(@PathVariable CPR: String) = service.deletePerson(CPR)

}
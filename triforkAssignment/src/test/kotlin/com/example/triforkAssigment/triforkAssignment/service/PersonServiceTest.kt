package com.example.triforkAssigment.triforkAssignment.service

import com.example.triforkAssigment.triforkAssignment.datasource.PersonDataSource
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PersonServiceTest {

    private val dataSource: PersonDataSource = mockk(relaxed = true)
    private val personService = PersonService(dataSource)


    @Test
    fun `should call its data source retrieve banks`(){

        personService.getPersons()

        verify(exactly = 1) { dataSource.retrievePersons() }

        }


}
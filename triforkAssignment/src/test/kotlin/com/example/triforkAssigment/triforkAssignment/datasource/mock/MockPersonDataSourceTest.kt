package com.example.triforkAssigment.triforkAssignment.datasource.mock



import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MockPersonDataSourceTest{
    private val mockPersonDataSource: MockPersonDataSource = MockPersonDataSource()

    @Test
    fun `should provide a collection of people`(){
        val persons = mockPersonDataSource.retrievePersons()
        assertThat(persons.size).isGreaterThanOrEqualTo(3)
        }

    @Test
    fun `should provide some mock data`(){

        // when
        val persons = mockPersonDataSource.retrievePersons()
        // then
        assertThat(persons).allMatch { it.cpr.length == 10}
        assertThat(persons).allMatch { it.blood_type.isNotBlank() }
        assertThat(persons).allMatch { it.name.isNotBlank() }
        assertThat(persons).allMatch { it.age != 0 }

        }
}
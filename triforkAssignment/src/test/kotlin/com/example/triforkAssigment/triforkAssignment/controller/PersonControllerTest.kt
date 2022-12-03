package com.example.triforkAssigment.triforkAssignment.controller

import com.example.triforkAssigment.triforkAssignment.model.Person
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.servlet.*
/*
@SpringBootTest
@AutoConfigureMockMvc
internal class PersonControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
) {

    val baseUrl = "/api/persons"

    @Nested
    @DisplayName("GET /api/persons")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class GetPersons {
        @Test
        fun `should return all the people`(){
            mockMvc.get(baseUrl)
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$[0].cpr") {value("8974390231")}
                }

            }

    }

    @Nested
    @DisplayName("GET /api/persons/{CPR}")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class GetPerson {
        @Test
        fun `should return the person with the given CPR`(){
            val cpr = "8974390231"

            mockMvc.get("$baseUrl/$cpr")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.blood_type") {value("O-")}
                    jsonPath("$.age") {value(30)}
                }
        }

        @Test
        fun `should return NOT FOUND if the CPR does not exist`(){
            // given
            val cpr = "does_not_exist"

            // when
            mockMvc.get("$baseUrl/$cpr")
                .andDo { print() }
                .andExpect { status { isNotFound() } }

            // then


            }

    }

    @Nested
    @DisplayName("POST /api/persons")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class PostNewPerson {
        @Test
        fun `should add a new person`(){
            // given
            val newPerson = Person("1156889944", "Name of a person", "B-", 21)

            // when
            val performPost = mockMvc.post(baseUrl) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(newPerson)
            }

            // then
            performPost
                .andDo { print() }
                .andExpect {
                    status { isCreated() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.cpr") {value("1156889944")}
                    jsonPath("$.name") {value("Name of a person")}
                    jsonPath("$.blood_type") {value("B-")}
                    jsonPath("$.age") {value(21)}
                }

            }
        
       @Test
       fun `should return BAD REQUEST if bank with given CPR number already exists`(){
           // given
           val invalidPerson = Person("8974390231", "Another name of a person", "B-", 20)
           
           // when
           val performPost = mockMvc.post(baseUrl){
               contentType = MediaType.APPLICATION_JSON
               content = objectMapper.writeValueAsString(invalidPerson)
           }
           
           // then
            performPost
                .andDo { print() }
                .andExpect { status { isBadRequest() } }
           
           }
    }
    
    @Nested
    @DisplayName("PATCH /api/banks")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class PatchAnExistingBank {
        @Test
        fun `should update an existing person`(){
            // given
            val updatePerson = Person("8974390231", "Name of a person", "B-", 22)

            // when
            val performPatchRequest = mockMvc.patch(baseUrl) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(updatePerson)
            }

            // then
            performPatchRequest
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON)
                    json(objectMapper.writeValueAsString(updatePerson))
                    }
                }

            mockMvc.get("$baseUrl/${updatePerson.cpr}")
                .andExpect { content { json(objectMapper.writeValueAsString(updatePerson)) } }

            }

        @Test
        fun `should return a NOT FOUND if no person with given CPR number`(){
            // given
            val invalidPerson = Person("does_not_exist", "A persons name here", "B-", 23)

            // when
            val performPatchRequest = mockMvc.patch(baseUrl){
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(invalidPerson)
            }

            // then
            performPatchRequest
                .andDo { print() }
                .andExpect { status { isNotFound() } }

            }
        
    }

    @Nested
    @DisplayName("DELETE /api/banks/{CPR}")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class DeleteAnExistingBank {
        @Test
        @DirtiesContext
        fun `should delete the person with the given CPR number`(){
            // given
            val cprNumber = "8974390231"

            // when
            mockMvc.delete("$baseUrl/$cprNumber")
                .andDo { print() }
                .andExpect {
                    status { isNoContent() }
                }

            // then
            mockMvc.get("$baseUrl/$cprNumber")
                .andExpect { status { isNotFound() } }

            }

        @Test
        fun `should return NOT FOUND if no person with given cpr number exists`(){
            // given
            val invalidCPRNumber = "does_not_exists"

            // when
            mockMvc.delete("$baseUrl/$invalidCPRNumber")
                .andDo { print() }
                .andExpect { status { isNotFound() } }


            }

    }

}*/
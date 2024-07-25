package com.example.lps.repo

import com.example.lps.domain.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.test.context.*
import org.springframework.transaction.annotation.*
import java.util.*
import kotlin.test.*

@SpringBootTest
class PersonRepositoryIT {

    @Autowired
    private lateinit var personRepository: PersonRepository

    @Test
    @Transactional // using transactional so that the data is rolled back after the test is done
    fun `insert and find by id`() {
        val id = UUID.randomUUID()
        val person = Person(id, "John", 35)
        personRepository.insertPerson(person)

        val result = personRepository.findPersonById(id)
        assertEquals(person, result)
    }
}
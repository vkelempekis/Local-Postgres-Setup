package com.example.lps.repo

import com.example.lps.domain.*
import org.springframework.jdbc.core.*
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.*
import java.sql.*
import java.util.*

@Repository
class PersonRepository(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) {

    fun insertPerson(person: Person) {
        val sql = "INSERT INTO Person (id, name, age) VALUES (:id, :name, :age)"
        jdbcTemplate.update(
            sql,
            MapSqlParameterSource(
                mapOf(
                    "id" to person.id,
                    "name" to person.name,
                    "age" to person.age
                )
            )
        )
    }

    fun findPersonById(id: UUID): Person? {
        val sql = "SELECT * FROM Person WHERE id = :id"
        return jdbcTemplate.query(sql, mapOf("id" to id), PersonRowMapper).firstOrNull()
    }

    private object PersonRowMapper : RowMapper<Person> {
        override fun mapRow(resultSet: ResultSet, rowNum: Int): Person = with(resultSet) {
            Person(
                id = UUID.fromString(getString("id")),
                name = getString("name"),
                age = getInt("age")
            )
        }
    }
}
package com.example.lps.domain

import java.util.UUID

data class Person(
    val id: UUID,
    val name: String,
    val age: Int
)
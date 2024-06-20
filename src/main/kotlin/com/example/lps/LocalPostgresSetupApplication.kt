package com.example.lps

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LocalPostgresSetupApplication

fun main(args: Array<String>) {
	runApplication<LocalPostgresSetupApplication>(*args)
}
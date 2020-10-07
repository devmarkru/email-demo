package ru.devmark.email

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EmailDemoApplication

fun main(args: Array<String>) {
    runApplication<EmailDemoApplication>(*args)
}

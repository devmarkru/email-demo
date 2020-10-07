package ru.devmark.email

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mails")
class EmailController(private val emailService: EmailService) {

    @PostMapping("/simple")
    fun sendSimpleEmail(@RequestParam("to") to: String) {
        emailService.sendSimpleEmail(to)
    }

    @PostMapping("/html")
    fun sendHtmlEmail(@RequestParam("to") to: String) {
        emailService.sendHtmlEmail(to)
    }
}
package ru.devmark.email.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.devmark.email.dto.MultipleReceiverRequest
import ru.devmark.email.dto.SingleReceiverRequest
import ru.devmark.email.service.EmailService

@RestController
@RequestMapping("/emails")
class EmailController(private val emailService: EmailService) {

    @PostMapping("/text")
    fun sendTextEmail(@RequestBody request: SingleReceiverRequest) {
        emailService.sendTextEmail(request)
    }

    @PostMapping("/html")
    fun sendHtmlEmail(@RequestBody request: MultipleReceiverRequest) {
        emailService.sendHtmlEmail(request)
    }
}

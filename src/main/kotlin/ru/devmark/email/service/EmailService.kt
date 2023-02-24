package ru.devmark.email.service

import jakarta.mail.internet.InternetAddress
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import ru.devmark.email.dto.MultipleReceiverRequest
import ru.devmark.email.dto.SingleReceiverRequest

@Service
class EmailService(
    private val javaMailSender: JavaMailSender,
    @Value("\${spring.mail.sender.email}") private val senderEmail: String,
    @Value("\${spring.mail.sender.text}") private val senderText: String
) {

    fun sendTextEmail(request: SingleReceiverRequest) {
        val message = SimpleMailMessage()
        message.setFrom(senderEmail)
        message.setTo(request.receiver)
        message.setSubject("Тестовое письмо")
        message.setText("Текстовое сообщение в тестовом письме.\nВторая строка.")
        javaMailSender.send(message)
    }

    fun sendHtmlEmail(request: MultipleReceiverRequest) {
        val message = javaMailSender.createMimeMessage()
        val helper = MimeMessageHelper(message)
        helper.setFrom(InternetAddress(senderEmail, senderText))
        helper.setTo(request.receivers.toTypedArray())
        helper.setCc(request.copy)
        helper.setBcc(request.hiddenCopy)
        helper.setSubject("Тестовое письмо")
        helper.setText("<p>Сообщение в формате <b>Html</b>.<br>Вторая строка.</p>", true)
        javaMailSender.send(message)
    }
}
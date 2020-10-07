package ru.devmark.email

import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import javax.mail.internet.InternetAddress

@Service
class EmailService(
        private val javaMailSender: JavaMailSender,
        @Value("\${spring.mail.sender.email}") private val senderEmail: String,
        @Value("\${spring.mail.sender.text}") private val senderText: String
) {

    fun sendSimpleEmail(receiver: String) {
        val message = SimpleMailMessage()
        message.setFrom(senderEmail)
        message.setTo(receiver)
        message.setSubject("Тестовое письмо")
        message.setText("Текстовое сообщение в тестовом письме.\nВторая строка.")
        javaMailSender.send(message)
    }

    fun sendHtmlEmail(receiver: String) {
        val message = javaMailSender.createMimeMessage()
        val helper = MimeMessageHelper(message)
        helper.setFrom(InternetAddress(senderEmail, senderText))
        helper.setTo(receiver)
        helper.setSubject("Тестовое письмо")
        helper.setText("<p>Сообщение в формате <b>Html</b>.<br>Вторая строка.</p>", true)
        javaMailSender.send(message)
    }
}
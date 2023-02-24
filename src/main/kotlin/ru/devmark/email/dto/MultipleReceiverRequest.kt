package ru.devmark.email.dto

data class MultipleReceiverRequest(
    val receivers: List<String>,
    val copy: String,
    val hiddenCopy: String,
)

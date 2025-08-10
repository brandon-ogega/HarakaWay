package com.example.harakaway.data.models

import kotlinx.serialization.Serializable


@Serializable
data class Job(
    val id: Int? = null,
    val createdAt: String? = null,
    val image_url: String,
    val companyName: String,
    val title: String,
    val jobCategory: String,
    val salary: String,
    val location: String,
    val status: String,
)

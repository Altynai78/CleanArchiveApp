package com.example.cleanarchiveapp.domein.models

import java.io.Serializable

data class Contacts(
    val id: Int,
    val name: String,
    val number: String,
    val address: String
): Serializable
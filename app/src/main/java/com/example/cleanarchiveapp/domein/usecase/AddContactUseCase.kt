package com.example.cleanarchiveapp.domein.usecase

import com.example.cleanarchiveapp.data.models.ContactEntity
import com.example.cleanarchiveapp.domein.repositories.ContactRepository


class AddContactUseCase(
    private val contactRepository : ContactRepository
) {

    fun execute(contactEntity: ContactEntity) {
    }

    suspend fun addContact(contactEntity: ContactEntity) {
        contactRepository.addContact(contactEntity)
    }

}
package com.example.cleanarchiveapp.domein.usecase

import com.example.cleanarchiveapp.data.models.ContactEntity
import com.example.cleanarchiveapp.domein.repositories.ContactRepository

class UpdateContactUseCase(
    private val contactRepository: ContactRepository
) {

    suspend fun execute(contactEntity: ContactEntity){
    }

    suspend fun updateContact(contactEntity: ContactEntity) {
        contactRepository.updateContact(contactEntity)
    }
}
package com.example.cleanarchiveapp.domein.usecase

import com.example.cleanarchiveapp.data.models.ContactEntity
import com.example.cleanarchiveapp.domein.repositories.ContactRepository


class DeleteContactUseCase(
    private val contactRepository: ContactRepository
) {

    suspend fun execute(contactEntity: ContactEntity){
    }

    suspend fun deleteContact(contactEntity: ContactEntity) {
        contactRepository.deleteContact(contactEntity)
    }
}
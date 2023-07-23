package com.example.cleanarchiveapp.domein.usecase

import android.provider.ContactsContract
import com.example.cleanarchiveapp.data.models.ContactEntity
import com.example.cleanarchiveapp.domein.repositories.ContactRepository
import kotlinx.coroutines.flow.Flow


class GetContactUseCase(
    private val contactRepository : ContactRepository
) {
    suspend fun execute(contactEntity: ContactEntity){

    }

    suspend fun getContacts(): Flow<Resource<List<ContactsContract.Contacts>>> {
        return contactRepository.getContacts()
    }
}
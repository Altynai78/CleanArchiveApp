package com.example.cleanarchiveapp.domein.repositories

import android.provider.ContactsContract
import com.example.cleanarchiveapp.data.models.ContactEntity
import kotlinx.coroutines.flow.Flow


interface ContactRepository {
    suspend fun addContact(contactEntity: ContactEntity)

    suspend fun getContacts(): Flow<Resource<List<ContactsContract.Contacts>>>

    suspend fun updateContact(contactEntity: ContactEntity)

    suspend fun deleteContact(contactEntity: ContactEntity)
    fun getContactFromLast(): Flow<Resource<List<ContactsContract.Contacts>>>
    fun getContactSortByName(): Flow<Resource<List<ContactsContract.Contacts>>>
}
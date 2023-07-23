package com.example.cleanarchiveapp.data.mappers

import android.provider.ContactsContract

fun ContactEntity.toEntity() : ContactsContract.Contacts {
    return Contacts(id = id, name = name, number = number, address = address)
}

fun ContactEntity.toContact() : ContactsContract.Contacts {
    return Contacts(id = id, name = name, number = number, address = address)
}
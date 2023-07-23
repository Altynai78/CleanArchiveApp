package com.example.cleanarchiveapp.data.models

import com.example.cleanarchiveapp.data.models.ContactEntity.Companion.CONTACT_TABLE

@Entity(tableName = CONTACT_TABLE)
data class ContactEntity(
    @PrimaryKey()
    @ColumnInfo(name = "contact_id")
    val id: Int,
    @ColumnInfo(name = "contact_name")
    val name: String,
    @ColumnInfo(name = "contact_number")
    val number: String,
    @ColumnInfo(name = "contact_address")
    val address: String
) {
    companion object {
        const val CONTACT_TABLE = "contact_table"
    }
}
package com.example.cleanarchiveapp.data.local

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addContact(familyEntity: Contacts)

    @Query("SELECT * FROM $CONTACT_TABLE")
    suspend fun getContact(): List<ContactEntity>

    @Query("SELECT * FROM $CONTACT_TABLE ORDER BY family_id DESC")
    suspend fun getContactFromLast(): List<ContactEntity>

    @Query("SELECT * FROM $CONTACT_TABLE ORDER BY family_name ASC")
    suspend fun getContactSortByName(): List<ContactEntity>

    @Update
    suspend fun updateContact(contactEntity: Contacts)

    @Delete
    suspend fun deleteContact(contactEntity: Contacts)
}
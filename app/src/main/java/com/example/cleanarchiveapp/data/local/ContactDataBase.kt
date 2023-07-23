package com.example.cleanarchiveapp.data.local

@Database(entities = [ContactEntity::class], version = 1)
abstract class ContactDataBase: RoomDatabase() {
    abstract fun contactDao(): ContactDao
}
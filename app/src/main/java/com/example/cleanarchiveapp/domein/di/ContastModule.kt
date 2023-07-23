package com.example.cleanarchiveapp.domein.di

import android.content.Context
import com.example.cleanarchiveapp.data.local.ContactDao
import com.example.cleanarchiveapp.data.local.ContactDataBase
import com.example.cleanarchiveapp.data.repositories.ContactRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
object ContactModule {

    @Singleton
    @Provides
    fun provideContactDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context = context,
        ContactDataBase::class.java,
        "contact_db"
    ).build()

    @Provides
    fun provideContactDao(contactDataBase: ContactDataBase) = contactDataBase.contactDao()

    @Provides
    fun provideContactRepository(contactDao: ContactDao): ContactRepository {
        return ContactRepositoryImpl(contactDao = contactDao)
    }
}
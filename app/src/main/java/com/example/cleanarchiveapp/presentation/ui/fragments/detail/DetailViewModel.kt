package com.example.cleanarchiveapp.presentation.ui.fragments.detail

import androidx.lifecycle.ViewModel
import com.example.cleanarchiveapp.data.models.ContactEntity
import com.example.cleanarchiveapp.domein.usecase.UpdateContactUseCase
import kotlinx.coroutines.Dispatchers

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val updateContactUseCase: UpdateContactUseCase,
    private val deleteContactUseCase: UpdateContactUseCase
) : ViewModel() {

    suspend fun updateContact(contactEntity: ContactEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            updateContactUseCase.execute(contactEntity = contactEntity)
        }
    }

    suspend fun deleteContact(contactEntity: ContactEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteContactUseCase.execute(contactEntity = contactEntity)
        }
    }
}
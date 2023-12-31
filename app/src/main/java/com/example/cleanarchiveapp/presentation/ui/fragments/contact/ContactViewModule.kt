package com.example.cleanarchiveapp.presentation.ui.fragments.contact

import androidx.lifecycle.ViewModel
import com.example.cleanarchiveapp.data.models.ContactEntity
import com.example.cleanarchiveapp.domein.usecase.AddContactUseCase
import com.example.cleanarchiveapp.domein.usecase.GetContactUseCase
import com.example.cleanarchiveapp.domein.utlis.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow

@HiltViewModel
class ContactViewModel @Inject constructor(
    private val getContactUseCase: GetContactUseCase,
    private val addContactUseCase: AddContactUseCase,
) : ViewModel() {

    private val _getAllContactStates = MutableStateFlow<UiState<List<ContactEntity>>>(UiState.EmptyState())
    val getAllContactStates = _getAllContactStates.asStateFlow()

    fun addContact(contactEntity: ContactEntity){
        viewModelScope.launch(Dispatchers.IO) {
            addContactUseCase.execute(contactEntity = contactEntity)
        }
    }



    fun getAllContact() {
        viewModelScope.launch {
            getContactUseCase.execute().collect {
                when (it) {
                    is Resource.Loading -> {
                        _getAllContactStates.value = UiState.Loading()
                    }

                    is Resource.Success -> {
                        _getAllContactStates.value = UiState.Success(it.data as List<ContactEntity>)
                    }

                    is Resource.Error -> {
                        _getAllContactStates.value = UiState.Error(it.message ?: "")
                    }
                }
            }
        }
    }
}
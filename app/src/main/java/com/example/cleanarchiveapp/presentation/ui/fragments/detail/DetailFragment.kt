package com.example.cleanarchiveapp.presentation.ui.fragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cleanarchiveapp.R
import com.example.cleanarchiveapp.data.models.ContactEntity

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getContact()
        initClickListeners()
    }

    private fun getContact() {
        with(binding){
            val contactEntity = (arguments?.getSerializable(KEY_CONTACT)) as ContactEntity
            etName.setText(contactEntity.name)
            etMother.setText(contactEntity.number)
            etFather.setText(contactEntity.address)
        }
    }

    private fun initClickListeners() {
        with(binding) {
            val contactEntity = (arguments?.getSerializable(KEY_CONTACT)) as ContactEntity
            btnUpdate.setOnClickListener {
                viewModel.viewModelScope.launch {
                    viewModel.updateContact(
                        ContactEntity(
                            id = contactEntity.id,
                            name = binding.etName.text.toString(),
                            number = binding.etMother.text.toString(),
                            address = binding.etFather.text.toString()
                        )
                    )
                }
                findNavController().navigateUp()
            }
            btnDelete.setOnClickListener {
                viewModel.viewModelScope.launch {
                    viewModel.deleteContact(contactEntity)
                }
                findNavController().navigateUp()
            }
        }
    }
}
package com.codingwithmitch.openapi.auth.viewModel

import androidx.lifecycle.ViewModel
import com.codingwithmitch.openapi.auth.repository.AuthRepository
import javax.inject.Inject

class AuthViewModel @Inject constructor(val authRepository: AuthRepository) : ViewModel() {

}
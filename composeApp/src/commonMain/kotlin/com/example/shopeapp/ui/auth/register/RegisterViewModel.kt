package com.example.shopeapp.ui.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopeapp.domain.model.UserLoginModel
import com.example.shopeapp.domain.model.UserModel
import com.example.shopeapp.domain.repository.PrefRepository
import com.example.shopeapp.domain.repository.UserLoginRepository
import com.example.shopeapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val userRepository: UserRepository,
    private val pref : PrefRepository
): ViewModel() {

    private val _userLogin = MutableStateFlow<UserModel?>(UserModel())
    val userLogin = _userLogin.asStateFlow()

    init {
        getUserByEmail("jitendra.office05@gmail.com")
    }

    fun registerUser(){
        viewModelScope.launch {
            userRepository.isUserRegistered(userLogin.value!!.email).collect {
                if (it) {
                    userRepository.registerUser(userLogin.value!!)
                }
            }
        }
    }

    fun getUserByEmail(email: String){
        viewModelScope.launch {
            userRepository.getUserByEmail(email).collect {
                _userLogin.value = it
            }
        }
    }


}
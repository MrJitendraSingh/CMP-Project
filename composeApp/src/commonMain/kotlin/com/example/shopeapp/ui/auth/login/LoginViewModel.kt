package com.example.shopeapp.ui.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopeapp.domain.model.UserLoginModel
import com.example.shopeapp.domain.repository.PrefRepository
import com.example.shopeapp.domain.repository.UserLoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val userLoginRepository: UserLoginRepository,
    private val pref : PrefRepository
): ViewModel() {

    private val _userLogin = MutableStateFlow<UserLoginModel?>(UserLoginModel(id = 1, username = "", password = ""))
    val userLogin = _userLogin.asStateFlow()

    init {
        getUsername()
        getPassword()
    }

    fun getUserById(id: Long) {
        viewModelScope.launch {
            _userLogin.value = userLoginRepository.getUserById(id)
        }
    }

    fun setUsername(username: String) {
        viewModelScope.launch {
            pref.setUsername(username)
        }
    }

    fun setPassword(password: String) {
        viewModelScope.launch {
            pref.setPassword(password)
        }
    }

    fun getUsername(){
        viewModelScope.launch {
            print("Username")
            _userLogin.value?.username = pref.getUsername()
            print(pref.getUsername())
        }
    }

    fun getPassword(){
        viewModelScope.launch {
            print("Password")
            _userLogin.value?.password = pref.getPassword()
            print(pref.getPassword())
        }
    }

}
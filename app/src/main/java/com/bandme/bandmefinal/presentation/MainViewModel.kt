package com.bandme.bandmefinal.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bandme.bandmefinal.data.LoginRepositoryImpl
import com.bandme.bandmefinal.data.ProfileRepositoryImpl
import com.bandme.bandmefinal.data.Response.UserProfile
import com.bandme.bandmefinal.domain.LoginRespository
import com.bandme.bandmefinal.domain.LoginUser
import com.bandme.bandmefinal.domain.ProfileRepository
import kotlinx.coroutines.launch

class MainViewModel(
    /*private val loginRepositoryImpl: LoginRepositoryImpl,
    private val profileRepositoryImpl: ProfileRepositoryImpl*/
    ): ViewModel() {

    private var loginRepositoryImpl: LoginRespository = LoginRepositoryImpl()
    private var profileRepositoryImpl: ProfileRepository = ProfileRepositoryImpl()

    private val _validateEmailMutableLiveData: MutableLiveData<Boolean?> = MutableLiveData()
    val validateEmailLiveData = _validateEmailMutableLiveData

    private val _validateLoginMutableLiveData: MutableLiveData<LoginUser?> = MutableLiveData()
    val validateLoginLiveData = _validateLoginMutableLiveData

    private val _createdAccountMutableLiveData: MutableLiveData<Boolean?> = MutableLiveData()
    val createAccountLiveData = _createdAccountMutableLiveData

    private val _confirmAccountMutableLiveData: MutableLiveData<LoginUser?> = MutableLiveData()
    val confirmAccountLiveData = _confirmAccountMutableLiveData

    private val _getUserProfileMutableLiveData: MutableLiveData<UserProfile> = MutableLiveData()
    val getUserProfileLiveData = _getUserProfileMutableLiveData

    fun validateEmail(email: String) {
        println("EMAIL RECIBIDO: $email")
        viewModelScope.launch {
            val response = loginRepositoryImpl.validateEmail(email = email)
            println("VIEWMODEL RESPONSE: $response")
            _validateEmailMutableLiveData.value = response
        }
    }

    fun validateLogin(email: String, password: String){
        println("EMAIL y PASSWORD: $email // $password")
        viewModelScope.launch {
            val response = loginRepositoryImpl.validateLogin(email = email, password = password)
            println("VIEWMODEL RESPONSE: $response")
            _validateLoginMutableLiveData.value = response
        }
    }

    fun creacteAccount(
        email: String,
        password: String,
        userType: String,
        provider: String,
        firstName: String? = "",
        lastName: String? = "",
        profilePhoto: String? = ""
    ){
        viewModelScope.launch {
            val response = loginRepositoryImpl.createAccount(email, password, userType, provider, firstName, lastName, profilePhoto)
            println("VIEWMODEL RESPONSE: $response")
            _createdAccountMutableLiveData.value = response
        }
    }

    fun confirmAccount(code: String){
        viewModelScope.launch {
            val response = loginRepositoryImpl.confirmAccount(code)
            println("VIEWMODEL RESPONSE: $response")
            _confirmAccountMutableLiveData.value = response
        }
    }

    fun getUserProfile(){
        viewModelScope.launch {
            val response = profileRepositoryImpl.getUserProfile()
            println("VIEWMODEL RESPONSE: $response")
            _getUserProfileMutableLiveData.value = response
        }
    }

}
package com.example.shopeapp.di

import com.example.shopeapp.data.repositoryImp.PrefRepositoryImp
import com.example.shopeapp.data.repositoryImp.UserLoginRepositoryFake
import com.example.shopeapp.domain.repository.PrefRepository
import com.example.shopeapp.domain.repository.UserLoginRepository
import com.example.shopeapp.ui.auth.login.LoginViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule : Module

val sharedModule = module {
    single<UserLoginRepository> { UserLoginRepositoryFake() }
    single<PrefRepository> { PrefRepositoryImp(get()) }
    viewModelOf(::LoginViewModel)
}
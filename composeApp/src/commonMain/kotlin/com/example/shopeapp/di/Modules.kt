package com.example.shopeapp.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.example.shopeapp.data.repositoryImp.PrefRepositoryImp
import com.example.shopeapp.data.repositoryImp.UserLoginRepositoryImp
import com.example.shopeapp.data.repositoryImp.UserRepositoryImp
import com.example.shopeapp.data.room.AppDatabase
import com.example.shopeapp.data.room.RoomDatabaseConfig
import com.example.shopeapp.domain.repository.PrefRepository
import com.example.shopeapp.domain.repository.UserLoginRepository
import com.example.shopeapp.domain.repository.UserRepository
import com.example.shopeapp.ui.auth.login.LoginViewModel
import com.example.shopeapp.ui.auth.register.RegisterViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule : Module

val sharedModule = module {
    single<AppDatabase> {
        get<RoomDatabaseConfig>()
            .getDatabaseBuilder()
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
    single<UserRepository> { UserRepositoryImp(get()) }
    single<UserLoginRepository> { UserLoginRepositoryImp(get()) }
    single<PrefRepository> { PrefRepositoryImp(get()) }
    viewModelOf(::LoginViewModel)
}

val viewModelModule = module {
    viewModelOf(::RegisterViewModel)
}
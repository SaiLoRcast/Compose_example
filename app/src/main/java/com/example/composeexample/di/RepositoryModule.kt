package com.example.composeexample.di

import com.example.composeexample.utils.EmployeesRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { EmployeesRepository(get()) }
}
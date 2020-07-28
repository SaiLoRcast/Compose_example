package com.example.composeexample.utils

import com.example.composeexample.di.NetworkApi
import com.example.composeexample.models.EmployeeInfo
import com.example.composeexample.models.NewEmployeeForm

class EmployeesRepository(private val service: NetworkApi) {

    suspend fun getEmployeesList(): List<EmployeeInfo> = service.getEmployees()

    suspend fun getNewEmployeeForm(): NewEmployeeForm = service.getNewEmployeeForm()
}
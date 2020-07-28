package com.example.composeexample.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.composeexample.models.AppState
import com.example.composeexample.models.EmployeeInfo
import com.example.composeexample.models.NewEmployeeForm
import com.example.composeexample.models.ViewState
import com.example.composeexample.utils.EmployeesRepository

class HomeViewModel(private val repository : EmployeesRepository) : ViewModel(){

    val getUsers: LiveData<List<EmployeeInfo>> = liveData {
        val result = repository.getEmployeesList()
        AppState.viewState = ViewState.LOADING
        emit(result)
        AppState.employeesListResult = result
        AppState.viewState = ViewState.SUCCESS
    }

    val getEmployeeForm: LiveData<NewEmployeeForm> = liveData {
        val result = repository.getNewEmployeeForm()
        AppState.viewState = ViewState.LOADING
        emit(result)
        AppState.newEmployeeFormResult = result
        AppState.viewState = ViewState.SUCCESS
    }

}
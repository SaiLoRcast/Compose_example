package com.example.composeexample.models

import androidx.compose.Model
import com.example.composeexample.models.ViewState

@Model
object AppState {
    var viewState = ViewState.DEFAULT
    var employeesListResult : List<EmployeeInfo>? = null
    var newEmployeeFormResult : NewEmployeeForm? = null
}
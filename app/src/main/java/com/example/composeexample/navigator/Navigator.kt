package com.example.composeexample.navigator

import androidx.compose.Model
import com.example.composeexample.models.EmployeeInfo
import com.example.composeexample.models.NewEmployeeForm

sealed class Navigator {
    object HomePage : Navigator()
    data class DetailPage(val employeeInfo: EmployeeInfo) : Navigator()
    object AboutPage : Navigator()
    data class NewEmployeeFormPage(val newEmployeeForm: NewEmployeeForm) : Navigator()
}

@Model
object AppNavigation {
    var currentScreen: Navigator = Navigator.HomePage
}

fun navigateTo(destination: Navigator) {
    AppNavigation.currentScreen = destination
}
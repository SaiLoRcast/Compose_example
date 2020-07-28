package com.example.composeexample.ui.home

import android.util.Log
import android.widget.Toast
import androidx.compose.Composable
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.material.*
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Add
import androidx.ui.material.icons.filled.Settings
import com.example.composeexample.models.AppState
import com.example.composeexample.models.ViewState
import com.example.composeexample.navigator.Navigator
import com.example.composeexample.navigator.navigateTo
import kotlin.coroutines.coroutineContext

@Composable
fun EmployeeListPage() {
    val employeesListResult = AppState.employeesListResult
    val newEmployeeFormResult = AppState.newEmployeeFormResult
    Scaffold(
        topAppBar = {
          TopAppBar(
              title = { Text(text = "Список работников")},
              actions = {
                  IconButton(onClick = {
                      navigateTo(Navigator.AboutPage)
                  }){
                      Icon(Icons.Filled.Settings)
                  }
              })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navigateTo(Navigator.NewEmployeeFormPage(newEmployeeFormResult!!))
                }
            ) {
                Icon(asset = Icons.Filled.Add)
            }
        },
        bodyContent = {
            Column {
                loadingData()
                VerticalScroller {
                    Column {
                        employeesListResult?.forEach {
                            ItemPerson(employeeInfo = it)
                        }
                    }
                }
            }

        }
    )
}

@Composable
fun loadingData() {
    if (AppState.viewState == ViewState.LOADING) {
        CircularProgressIndicator()
    }
}

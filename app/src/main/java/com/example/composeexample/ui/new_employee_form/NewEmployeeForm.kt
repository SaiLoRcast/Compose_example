package com.example.composeexample.ui.new_employee_form

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Modifier
import androidx.ui.foundation.*
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxWidth
import androidx.ui.material.*
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.ArrowBack
import com.example.composeexample.models.NewEmployeeForm
import com.example.composeexample.navigator.Navigator
import com.example.composeexample.navigator.navigateTo
import com.example.composeexample.utils.Dimens
import com.example.composeexample.utils.themeTypography

@Composable
fun NewEmployeeForm(newEmployeeForm: NewEmployeeForm) {
    Scaffold(
        topAppBar = {
            TopAppBar(
                title = {Text(text = "Форма добавления работника")},
                navigationIcon = {
                    IconButton(onClick = {
                        navigateTo(Navigator.HomePage)
                    }) {
                        Icon(Icons.Filled.ArrowBack)
                    }
                }
            )
        },
        bodyContent = {
            Box(
                padding = Dimens.medium_content,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(text = newEmployeeForm.titleName, style = themeTypography.h6)
                    val state = state { TextFieldValue("Введите выа") }
                    TextField(
                        value = state.value,
                        onValueChange = { state.value = it }
                    )
                    Text(text = newEmployeeForm.titlePhone, style = themeTypography.body1)
                }
            }

        })
}




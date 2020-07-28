package com.example.composeexample.ui.home

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.material.Card
import com.example.composeexample.models.EmployeeInfo
import com.example.composeexample.navigator.Navigator
import com.example.composeexample.navigator.navigateTo
import com.example.composeexample.utils.Dimens
import com.example.composeexample.utils.themeTypography

@Composable
fun ItemPerson(employeeInfo: EmployeeInfo) {
    Clickable(onClick = {
        navigateTo(Navigator.DetailPage(employeeInfo = employeeInfo))
    }) {
        Card {
            Box(
                padding = Dimens.medium_content,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row {
                    Column {
                        Text(text = employeeInfo.name, style = themeTypography.h6)
                        Text(text = employeeInfo.phone, style = themeTypography.body1)
                    }
                }
            }
        }
    }
}
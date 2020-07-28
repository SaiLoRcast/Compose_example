package com.example.composeexample.ui.detail

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.preferredHeight
import androidx.ui.material.IconButton
import androidx.ui.material.Scaffold
import androidx.ui.material.TopAppBar
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.ArrowBack
import com.example.composeexample.models.EmployeeInfo
import com.example.composeexample.navigator.Navigator
import com.example.composeexample.navigator.navigateTo
import com.example.composeexample.utils.Dimens
import com.example.composeexample.utils.themeTypography

@Composable fun EmployeeDetailPage(employeeInfo: EmployeeInfo) {
    Scaffold (
        topAppBar = {
            TopAppBar(
                title = {},
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
        DetailView(employeeInfo = employeeInfo)
    })
}


@Composable fun DetailView(employeeInfo: EmployeeInfo){
    Column(modifier = Modifier.fillMaxWidth(), horizontalGravity = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.preferredHeight(Dimens.profile_image))
//        Box(shape = CircleShape, modifier = Modifier.preferredSize(Dimens.profile_image)) {
//            GlideImage(model = employeeInfo.avatar)
//        }
        Text("Имя ${employeeInfo.name} ",  style = themeTypography.h6)
        Text("Номер телефона ${employeeInfo.phone}", style = themeTypography.body1)
    }
}
package com.example.composeexample.ui.info

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.material.IconButton
import androidx.ui.material.Scaffold
import androidx.ui.material.TopAppBar
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.ArrowBack
import androidx.ui.unit.dp
import com.example.composeexample.navigator.Navigator
import com.example.composeexample.navigator.navigateTo
import com.example.composeexample.utils.Dimens
import com.example.composeexample.utils.themeTypography

@Composable
fun AboutPage() {
    Scaffold(
        topAppBar = {
            TopAppBar(
                title = {Text(text = "О приложении")},
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
            InfoView()
        })
}

@Composable
fun InfoView() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalGravity = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.preferredHeight(Dimens.profile_image))
//        Image(imageResource(R.drawable.profile),modifier = Modifier.preferredSize(Dimens.profile_image))
        Text("Полыгалов Константин", style = themeTypography.h6)
        Text("sailorcast@mail.ru", style = themeTypography.body1)

        Box(modifier = Modifier.preferredHeight(256.dp))
        Row(verticalGravity = Alignment.CenterVertically) {
//            Image(imageResource(R.drawable.android_jetpack),modifier = Modifier.preferredSize(Dimens.profile_image))
            Spacer(modifier = Modifier.preferredSize(width = 8.dp, height = 0.dp))
            Text("Android Jetpack Compose")
        }
    }
}
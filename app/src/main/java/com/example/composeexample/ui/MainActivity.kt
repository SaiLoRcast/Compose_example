package com.example.composeexample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.ui.animation.Crossfade
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import com.example.composeexample.navigator.AppNavigation
import com.example.composeexample.navigator.Navigator
import com.example.composeexample.ui.detail.EmployeeDetailPage
import com.example.composeexample.ui.home.EmployeeListPage
import com.example.composeexample.ui.home.viewmodel.HomeViewModel
import com.example.composeexample.ui.info.AboutPage
import com.example.composeexample.ui.new_employee_form.NewEmployeeForm
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Crossfade(AppNavigation.currentScreen) { screen ->
                    when (screen) {
                        is Navigator.HomePage -> EmployeeListPage()
                        is Navigator.AboutPage -> AboutPage()
                        is Navigator.DetailPage -> EmployeeDetailPage(screen.employeeInfo)
                        is Navigator.NewEmployeeFormPage -> NewEmployeeForm(screen.newEmployeeForm)
                    }
                }
            }
        }

        viewModel.getUsers.observe(this, Observer {
        })
        viewModel.getEmployeeForm.observe(this, Observer {
        })
    }

    override fun onBackPressed() {
        AppNavigation.currentScreen = Navigator.HomePage
    }
}
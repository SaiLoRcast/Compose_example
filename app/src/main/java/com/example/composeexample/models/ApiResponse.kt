package com.example.composeexample.models

data class EmployeeInfo(
    val id: Int,
    val name: String,
    val phone: String
)

data class NewEmployeeForm(
    val titleName: String,
    val editableTextName: String,
    val titlePhone: String,
    val editableTextPhone: String
)


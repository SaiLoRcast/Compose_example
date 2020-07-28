package com.example.composeexample.di

import com.example.composeexample.BuildConfig
import com.example.composeexample.models.EmployeeInfo
import com.example.composeexample.models.NewEmployeeForm
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

val networkModule = module {
    factory {
        createWebService<NetworkApi>(
            createHttpClient(),
            BuildConfig.BASE_URL
        )
    }
}

fun createHttpClient(): OkHttpClient {
    val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

    return client.build()
}

inline fun <reified T> createWebService(
    okHttpClient: OkHttpClient,
    baseUrl: String
): T {

    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .client(okHttpClient)
        .build()
    return retrofit.create(T::class.java)
}

interface NetworkApi {

    @GET("api/employees")
    suspend fun getEmployees(): List<EmployeeInfo>

    @GET("api/employees/getForm")
    suspend fun getNewEmployeeForm(): NewEmployeeForm

    @POST("api/employees")
    fun addEmployee(@Body employeeInfo: EmployeeInfo): Call<List<EmployeeInfo>>
}
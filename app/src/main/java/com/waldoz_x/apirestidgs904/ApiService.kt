package com.waldoz_x.apirestidgs904

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @GET("posts") // jsonplaceholder no tiene /students, usa /posts
    suspend fun getStudents(): List<Student>

    @POST("posts")
    fun addStudent(@Body studentData: Student): Call<StudentResponse>

    @PUT("posts/{id}")
    fun updateStudent(@Path("id") studentId: Int, @Body studentData: Student): Call<StudentResponse>

    @DELETE("posts/{id}")
    fun deleteStudent(@Path("id") studentId: Int): Call<Unit>

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        private var apiService: ApiService? = null

        fun getInstance(): ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}
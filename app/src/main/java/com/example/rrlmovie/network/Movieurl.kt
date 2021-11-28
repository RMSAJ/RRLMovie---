
package com.example.rrlmovie.network

import com.example.rrlmovie.network.Response
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.themoviedb.org"

//private const val API_KEY = "a45bd525d7f3152d793dd5b9e91d8074"



// for using the moshi library
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


// for using retroit library
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

// for getting the data from the url

interface Movieurls {
    @GET("/3/movie/popular?api_key=a45bd525d7f3152d793dd5b9e91d8074")
    suspend fun getMovieList() : Response
//    suspend fun getMovieList2() : Response

}


object MovieApi {
    val retrofitService: Movieurls by lazy {
        retrofit.create(Movieurls::class.java)
    }
}
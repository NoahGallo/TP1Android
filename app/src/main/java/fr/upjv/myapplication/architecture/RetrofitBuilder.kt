package fr.upjv.myapplication.architecture

import CatFactEndpoint
import com.google.gson.GsonBuilder
import fr.upjv.myapplication.data.remote.ChuckNorrisQuoteEndpoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    // Existing Retrofit for Chuck Norris API (unchanged)
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.chucknorris.io/jokes/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    fun getChuckNorrisQuote(): ChuckNorrisQuoteEndpoint =
        retrofit.create(ChuckNorrisQuoteEndpoint::class.java)

    // New Retrofit instance for Cat Fact API
    private val retrofitCat: Retrofit = Retrofit.Builder()
        .baseUrl("https://catfact.ninja/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    fun getCatFact(): CatFactEndpoint =
        retrofitCat.create(CatFactEndpoint::class.java)
}

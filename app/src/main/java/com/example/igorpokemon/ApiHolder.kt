package com.example.igorpokemon

import com.example.igorpokemon.mvp.model.api.IDataSource
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiHolder {
    val api: IDataSource by lazy {
        val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .excludeFieldsWithoutExposeAnnotation()
            .create()

        Retrofit.Builder()
            // если в адресе только домен "https://pokeapi.co" - то можно без слэша
            // (кстати, в логах меньше skipped __ frames и Davey!
            // если как здесь - то в конце нужен слэш
            .baseUrl("https://pokeapi.co/api/v2/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(IDataSource::class.java)
    }
}
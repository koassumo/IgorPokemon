package com.example.igorpokemon.mvp.model.api

import com.example.igorpokemon.mvp.model.entity.PokedexKanto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface IDataSource {
    // можно и так записать @GET("./pokedex/kanto")
    @GET("pokedex/kanto")
    fun getUsers(): Single<PokedexKanto>

}
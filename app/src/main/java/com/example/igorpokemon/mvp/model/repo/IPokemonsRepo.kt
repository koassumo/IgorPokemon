package com.example.igorpokemon.mvp.model.repo

import com.example.igorpokemon.mvp.model.entity.PokedexKanto
import io.reactivex.rxjava3.core.Single

interface IPokemonsRepo {
    fun getPokemons(): Single<PokedexKanto>
}
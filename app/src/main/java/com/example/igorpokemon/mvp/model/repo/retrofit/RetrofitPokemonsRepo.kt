package com.example.igorpokemon.mvp.model.repo.retrofit

import com.example.igorpokemon.mvp.model.api.IDataSource
import com.example.igorpokemon.mvp.model.entity.PokedexKanto
import com.example.igorpokemon.mvp.model.repo.IPokemonsRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

data class RetrofitPokemonsRepo (val api: IDataSource): IPokemonsRepo {
    override fun getPokemons(): Single<PokedexKanto> = api.getUsers()
        .subscribeOn(Schedulers.io())                       // в каком потоке торчит observable
        .observeOn(AndroidSchedulers.mainThread())          // в каком потоке observer
}
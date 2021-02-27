package com.example.igorpokemon.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.igorpokemon.ApiHolder
import com.example.igorpokemon.R
import com.example.igorpokemon.mvp.model.NotesRepository
import com.example.igorpokemon.mvp.model.entity.PokedexKanto
import com.example.igorpokemon.mvp.model.entity.PokemonSpecies
import com.example.igorpokemon.mvp.model.repo.retrofit.RetrofitPokemonsRepo
import com.example.igorpokemon.ui.adapter.NotesRVAdapter
import com.example.igorpokemon.ui.image.GlideImageLoader
import io.reactivex.rxjava3.core.Single
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mRVadapter: NotesRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        val anySingle: Single<PokedexKanto> = RetrofitPokemonsRepo(ApiHolder().api).getPokemons()
        anySingle?.subscribe({ s ->
//            println("---------------------------------:" + (s.pokemon_entries?.size ?: "sdfs"))
//            println(s.pokemon_entries?.get(0)?.pokemon_species?.pokemonName)
//            println(s.pokemon_entries?.get(1)?.pokemon_species?.pokemonName)
//            println(s.pokemon_entries?.get(2)?.pokemon_species?.pokemonName)

            val pokemonSpeciesList: MutableList<PokemonSpecies> = arrayListOf()
            s.pokemon_entries?.let {
                for (i in 0 .. (it.size - 1) ) {
                    pokemonSpeciesList.add(it.get(i).pokemon_species!!)
                    pokemonSpeciesList[i].pokemonUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + (i+1) + ".png"
                }
            }
            mRVadapter.updateNote(pokemonSpeciesList)
        }, {
            println("onError: ${it.message}")
        })

//
//        RetrofitGithubUsersRepo(ApiHolder().api).getUsers()
//            .observeOn(mainThreadScheduler)
//            .subscribe({ s ->
//                println(s)
//
//                //mRVdapter.newNotes(NotesRepository.getNotes())
//            }, {
//                println("onError: ${it.message}")
//            })


        val imL = GlideImageLoader()
        // 1.1. ADAPTER создаем
        mRVadapter = NotesRVAdapter(imL)
        // 1.2. передаем данные (которые забрали в моделе)
        mRVadapter.pokemonSpecies = NotesRepository.getNotes()

        // 1.3. накладываем адаптер на recycle
        rv_notes.adapter = mRVadapter

        // 2.1. LAYOUT создаем (!!! можно Grid или любой) и 2.2. накладываем layout на recycler
        rv_notes.layoutManager = LinearLayoutManager(this)

        //mRVdapter.updateNote(NotesRepSecond.getNotes())

//        viewModel.getViewState().observe(this, Observer { value ->
//            value?.let {
//                adapter.notes = it.notes
//            }
//        })
    }


}
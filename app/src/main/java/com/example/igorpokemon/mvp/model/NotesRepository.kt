package com.example.igorpokemon.mvp.model

import com.example.igorpokemon.mvp.model.entity.PokemonSpecies


object NotesRepository {
    private val POKEMON_SPECIES: List<PokemonSpecies> = listOf(
        PokemonSpecies(
            "Первая заметка",
//            "lskdfjlksdfj dslfkjds dsfalkjalsdf sskdfj sdlfkjf sadfljk",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"
            //0xFFAAD6A2.toInt(),
            //false
            ),
        PokemonSpecies(
            "Вторая заметка",
//            "ШЩЩЩШШ ммтмтмдымь ывдтьа зуцоцуцуо ваыиваы9овыа",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png"
            //0xFFDCA38B.toInt(),
            //false
            ),
        PokemonSpecies(
            "Третья заметка",
//            "ждл жлдждл жд лопоп ждлыва  ыолвдаав шуццуш лдлоыва ваыдлоывдло дывлао",
            "https://avatars.githubusercontent.com/u/2?v=4"
            //0xFF81D4FA.toInt(),
            //false
            ),
        PokemonSpecies(
            "Червертая заметка",
//            "ШЩЩЩШШ ммтмтмдымь ывдтьа зуцоцуцуо ваыиваы9овыа",
            "https://avatars.githubusercontent.com/u/1?v=4"
            //0xfff04597.toInt(),
            //false
            )
//        ,
//        Note(
//            "Пятая заметка",
//            "ццууууу жлдждл жд лопоп ждлыва  ыолвдаав шуццуш лдлоыва ваыдлоывдло дывлаоываыав ваыфв фываыва фываы фыв ф вфыавываыф",
//            "https://avatars.githubusercontent.com/u/1?v=4"
//            //0xfff06292.toInt(),
//            //false
//            ),
//        Note(
//            "Шестая заметка",
//            "ШЩЩЩШШ ммтмтмдымь ывдтьа зуцоцуцуо ваыиваы9овыа",
//            "https://avatars.githubusercontent.com/u/1?v=4"
//            //0xfff06292.toInt(),
//            //false
//        ),
//        Note(
//            "Седьмая заметка",
//            "ццууууу жлдждл жд лопоп ждлыва  ыолвдаав шуццуш лдлоыва ваыдлоывдло дывлаоываыав ваыфв фываыва фываы фыв ф вфыавываыф",
//            "https://avatars.githubusercontent.com/u/1?v=4"
//            //0xfff06292.toInt(),
//            //false
//        )
    )

    fun getNotes (): List<PokemonSpecies> {
        return POKEMON_SPECIES
    }
}
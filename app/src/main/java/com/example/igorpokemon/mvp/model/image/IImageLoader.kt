package com.example.igorpokemon.mvp.model.image

interface IImageLoader <T>{
    fun loadInto (url: String, container: T)
}
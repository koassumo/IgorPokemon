package com.example.igorpokemon.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.igorpokemon.R
import com.example.igorpokemon.mvp.model.entity.PokedexKanto
import com.example.igorpokemon.mvp.model.entity.PokemonSpecies
import com.example.igorpokemon.mvp.model.image.IImageLoader
import kotlinx.android.synthetic.main.item_note.view.*

class NotesRVAdapter (val imageLoader : IImageLoader<ImageView>): RecyclerView.Adapter<NotesRVAdapter.ViewHolder> () {

    var pokemonSpecies: List<PokemonSpecies> = listOf()
        set (value){
            field = value
            notifyDataSetChanged()
        }

    // 0. Определяем CLASS ViewHolder (т.е. только шаблон из чего состоит itemView, для связи с каждым внутр.элементов itemView)
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        // На вход конструктор (?) берет переданную Item и разбираем ее на составные части
        // при этом предварительно найти все вьюшки (как в java) здесь не требуется,
        // (но - это расход ресурсов, поэтому нужно как-то закэшировать)
        fun bind(pokemonSpecies: PokemonSpecies) {
            itemView.tv_title.text = pokemonSpecies.pokemonName
            itemView.tv_text.text = pokemonSpecies.pokemonUrl
            pokemonSpecies.pokemonUrl?.let { imageLoader.loadInto(it, itemView.iv_avatar) }
            //note.mColor?.let { itemView.setBackgroundColor(it) }

            //      P.S. визуально красивее через with (хотя ... ну, не знаю)
            //        fun bind1(note: Note) = with(itemView){
            //            tv_title.text = note.mTitle
            //            tv_text.text = note.mText
            //            setBackgroundColor(note.mColor)
        }


    }

    // Далее переопределяем ТРИ метода
    // 1. Recycler должен знать сколько у него элементов
    override fun getItemCount(): Int = pokemonSpecies.size

    // 2. Создаем каждую конкретную itemView
    // берем из item-layout из ресорсов и передаем его к новый объект холдера, который разбирает его по частям
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))

    // 3. Наполняем viewHolder (подставляем в шаблон конкретные значения из Model)
    // holder отделен от данных, т.к. это RecycleView, т.е. переиспользуемые холдеры
    override fun onBindViewHolder(holder: NotesRVAdapter.ViewHolder, position: Int) = holder.bind(
        pokemonSpecies[position]
    )

    fun updateNote(newNotes: MutableList<PokemonSpecies>) {
        //this.pokemonSpecies.
        //val arr = {
        //    for (safds in newNotes.pokemon_entries!!)

        //}
        this.pokemonSpecies = newNotes
//        notifyDataSetChanged()
    }

}
package com.tirgei.rickandmorty.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tirgei.domain.models.Character
import com.tirgei.rickandmorty.R
import com.tirgei.rickandmorty.databinding.ItemCharacterBinding
import com.tirgei.rickandmorty.ui.base.BaseViewHolder
import com.tirgei.rickandmorty.utils.bind

class CharactersAdapter(private val callback: (Character) -> Unit) : RecyclerView.Adapter<BaseViewHolder<Character>>() {
    private val characters = mutableListOf<Character>()

    fun addCharacters(characters: List<Character>) {
        this.characters.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Character> {
        return CharacterHolder(parent.bind(R.layout.item_character))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Character>, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int = characters.size

    inner class CharacterHolder(private val binding: ItemCharacterBinding): BaseViewHolder<Character>(binding) {
        override fun bind(data: Character) {
            binding.character = data
            binding.root.setOnClickListener { callback(data) }
        }
    }

}
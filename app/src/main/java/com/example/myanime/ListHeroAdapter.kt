package com.example.myanime

import android.content.Intent
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView
import com.example.myanime.databinding.ItemRowHeroBinding

class ListHeroAdapter(
    private val listHero: ArrayList<Hero>
) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {
private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemCallback(onItemCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemCallback
    }

    class ListViewHolder(var binding: ItemRowHeroBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, desc, photo, eps) = listHero[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.itemDesc.text = desc
        holder.binding.tvTotalEps.text = eps
        holder.itemView.setOnClickListener{ onItemClickCallback.onItemClicked(listHero[holder.adapterPosition])  }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }
}
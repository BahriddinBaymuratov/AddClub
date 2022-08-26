package com.example.recycleclubs.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleclubs.databinding.ItemLayoutBinding
import com.example.recycleclubs.model.Club

class ClubAdapter : RecyclerView.Adapter<ClubAdapter.ClubViewHolder>() {

    lateinit var onClick: (Club) -> Unit

    val clubList: MutableList<Club> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        return ClubViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bind(clubList[position])
    }

    override fun getItemCount(): Int = clubList.size

    inner class ClubViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(club: Club) {
            binding.apply {
                imageItem.setBackgroundResource(club.logo)
                textItem.text = club.name
            }
            itemView.setOnClickListener {
                clubList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
                onClick.invoke(club)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addClub(club: Club) {
        clubList.add(club)
        notifyDataSetChanged()
    }

}
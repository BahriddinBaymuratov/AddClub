package com.example.recycleclubs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recycleclubs.adapter.ClubAdapter
import com.example.recycleclubs.databinding.ActivityMainBinding
import com.example.recycleclubs.databinding.ItemLayoutBinding
import com.example.recycleclubs.model.Club
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var clubAdapter: ClubAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clubAdapter = ClubAdapter()
        setupRV()

        binding.btnAdd.setOnClickListener {
            clubAdapter.addClub(randomClub())
            binding.TextView.isVisible = clubAdapter.clubList.isEmpty()
        }
        clubAdapter.onClick = {
            binding.TextView.isVisible = clubAdapter.clubList.isEmpty()
        }
    }
    private fun setupRV() = binding.recycleView.apply{
        adapter = clubAdapter
        layoutManager = GridLayoutManager(this@MainActivity, 3)

    }
    private fun randomClub(): Club{
        val random = Random()
        val list = listOf(
            Club("Barcelona", R.drawable.img_2),
            Club("Chelsea", R.drawable.img),
            Club("Liverpool", R.drawable.img_1),
            Club("Man City", R.drawable.img_3),
            Club("Real Madrid", R.drawable.img_5),
            Club("Tottenham", R.drawable.img_6),
            Club("PSG", R.drawable.img_7)
        )
        return list[random.nextInt(list.size)]
    }


}
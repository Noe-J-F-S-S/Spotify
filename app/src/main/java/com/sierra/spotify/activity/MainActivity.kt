package com.sierra.spotify.activity

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sierra.spotify.SongRepository
import com.sierra.spotify.adapter.MusicsAdapter
import com.sierra.spotify.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var spotifyRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setRecyclerView()
    }
    private fun setRecyclerView() {
        spotifyRecyclerView = binding.musicList
        spotifyRecyclerView.layoutManager = LinearLayoutManager(this)
        val songs = SongRepository()
        val musicsAdapter = MusicsAdapter(songs.songs)
        spotifyRecyclerView.adapter = musicsAdapter
    }
    fun play(view: View){
        Toast.makeText(this, "play", Toast.LENGTH_SHORT).show()
    }
    fun pause(view: View){
        Toast.makeText(this, "pause", Toast.LENGTH_SHORT).show()
    }


}
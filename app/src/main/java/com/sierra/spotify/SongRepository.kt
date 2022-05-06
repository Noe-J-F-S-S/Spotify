package com.sierra.spotify

import com.sierra.spotify.model.Song

class SongRepository (val songs:MutableList<Song> = ArrayList()){
    init {
        getDataSongs()
    }

    fun getDataSongs(): List<Song> {
        songs.add(Song(100, "Lamento boliviano", "Rock","1:59", "imc_1"))
        songs.add(Song(200, "Sin ti estoy bien ", "Balada","3:36", "imc_2"))
        songs.add(Song(300, "Por Ti ", "Trap", "3:15","imc_3"))
        songs.add(Song(400, "Mil horas", "Rock", "2:48","imc_4"))
        songs.add(Song(500, "De musica ligera", "Rock", "4:50","imc_5"))
        songs.add(Song(600, "Nena prendelo", "Trap", "3:53","imc_6"))
        songs.add(Song(700, "Di que no te vas", "Folk pop", "3:58","imc_7"))
        songs.add(Song(800, "Fix you", "Alternativa","4:53", "imc_8"))
        songs.add(Song(900, "Lost on you", "Pop", "5:08","imc_9"))
        songs.add(Song(1000, "The beautiful people", "Rock","3:47", "imc_10"))
        return songs
    }
}
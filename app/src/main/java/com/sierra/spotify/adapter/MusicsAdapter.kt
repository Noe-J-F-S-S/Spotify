package com.sierra.spotify.adapter

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.sierra.spotify.databinding.ItemMusicBinding
import com.sierra.spotify.model.Song
import android.util.Log
import de.hdodenhof.circleimageview.CircleImageView

class MusicsAdapter(private val dataSet: List<Song>): RecyclerView.Adapter<MusicsAdapter.ViewHolder>() {

    /**
     * Proporciona una referencia al tipo de vistas que está utilizando
     * (custom ViewHolder).
     */
    class ViewHolder(private val binding: ItemMusicBinding) : RecyclerView.ViewHolder(binding.root) {
        var picture: ImageView = binding.pictureImage
        var fullName: TextView = binding.tvFullname
        var genero: TextView = binding.tvGenero
        var tiempo: TextView = binding.tvTiempo
        var additionalText: TextView = binding.aditionalText
        var btnViewDetail: ImageButton = binding.btnStart
        val share: ImageButton = binding.btnShare
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Crear una nueva vista, que define la interfaz de usuario del elemento de la lista
        val itemBinding = ItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    // Reemplazar el contenido de una vista (invocado por el administrador de diseño)
    override fun onBindViewHolder(binding: ViewHolder, position: Int) {
        // Obtenga el elemento de su conjunto de datos en esta posición y reemplace el contenido de la vista con ese elemento
        val song: Song = this.dataSet[position]

        val context = binding.itemView.context

        val idRes = context.resources.getIdentifier(song.picture, "drawable", context.packageName)

        binding.fullName.text = song.fullname
        binding.genero.text = song.genero
        binding.tiempo.text = song.tiempo
        binding.picture.setImageResource(idRes)

        binding.picture.setOnClickListener {
            Toast.makeText(context, "Click Picture $position", Toast.LENGTH_SHORT).show()
        }


        if (song.genero == "Rock") {
            binding.btnViewDetail.visibility = View.VISIBLE
            binding.btnViewDetail.setOnClickListener {
                Toast.makeText(context, "Te gusta ${song.fullname}", Toast.LENGTH_SHORT).show()
            }
        }

        binding.share.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            //val nombre =fullname.getText().toString()
            // val genera = genero.text.toString()
            //val duracion = tiempo.text.toString()
            intent.type = "text/plain"
            intent.setPackage("com.whatsapp")
            intent.putExtra(Intent.EXTRA_TEXT, song.fullname)
            try {
                context.startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(
                    context,
                    "La aplicación Whastapp no se encuentra instalada en el dispositivo.",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }




    //Devuelve el tamaño de tu conjunto de datos (invocado por el administrador de diseño)
    override fun getItemCount(): Int = dataSet.size
}
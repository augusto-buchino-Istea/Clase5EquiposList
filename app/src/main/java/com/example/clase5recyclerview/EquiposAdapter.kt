package com.example.clase5recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class EquiposAdapter(val context: Context) : ListAdapter<Equipo, EquiposAdapter.ViewHolder>(DiffCallBack) {
    lateinit var onItemClickListener: (Equipo) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val nombre : TextView = view.findViewById(R.id.textViewNombre)
        private val Campeonatos: TextView = view.findViewById(R.id.textViewCampeonatos)
        private val imageView: ImageView = view.findViewById(R.id.imageViewEscudo)

        fun bind (equipo: Equipo) {
            nombre.text = equipo.nombre
            Campeonatos.text = "Campeonatos: " + equipo.campeonatos.toString()

            Glide.with(context)
                .load(equipo.urlEscudo)
                .into(imageView)

            view.setOnClickListener {
                onItemClickListener(equipo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquiposAdapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.itemlist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: EquiposAdapter.ViewHolder, position: Int) {
        val equipo = getItem(position)
        holder.bind(equipo)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Equipo>() {
        override fun areItemsTheSame(oldItem: Equipo, newItem: Equipo): Boolean {
            return  oldItem.Id == newItem.Id
        }

        override fun areContentsTheSame(oldItem: Equipo, newItem: Equipo): Boolean {
            return oldItem == newItem
        }
    }
}

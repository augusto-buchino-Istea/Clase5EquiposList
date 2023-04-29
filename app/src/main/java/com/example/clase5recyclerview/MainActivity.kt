package com.example.clase5recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EquiposAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewPokemon)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = EquiposAdapter(applicationContext)
        recyclerView.adapter = adapter

        adapter.submitList(getListadoEquipos())
//        adapter.onItemClickListener = { pokemon ->
//            val intent = Intent(this, DetailActivity::class.java)
//            intent.putExtra("name", pokemon.name)
//            intent.putExtra("url", pokemon.url)
//            startActivity(intent)
//        }
    }

    private fun getListadoEquipos(): MutableList<Equipo>? {
        return mutableListOf(
            Equipo(1, "Boca Juniors",33,"https://upload.wikimedia.org/wikipedia/commons/c/c9/Boca_escudo.png"),
            Equipo(2, "River Plate",30,"https://upload.wikimedia.org/wikipedia/commons/3/3f/Logo_River_Plate.png"),
            Equipo(3, "Independiente",22,"https://es.wikipedia.org/wiki/Club_Atl%C3%A9tico_Independiente#/media/Archivo:Escudo_del_Club_Atl%C3%A9tico_Independiente.svg")
        )
    }
}
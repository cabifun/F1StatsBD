package com.example.f1stats

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    class PilotStatsAdapter(private val pilotStatsList: List<PilotStats>) : RecyclerView.Adapter<PilotStatsAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val pilotName: TextView = view.findViewById(R.id.pilotName)
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pilot_stats, parent, false)
            return ViewHolder(view)
        }


        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val pilotStats = pilotStatsList[position]
            holder.pilotName.text = pilotStats.nome


            holder.itemView.setOnClickListener {
                val intent = Intent(holder.itemView.context, DetalhesPilotoActivity::class.java)
                intent.putExtra("nomePiloto", pilotStats.nome)
                intent.putExtra("corridas", pilotStats.corridas)
                intent.putExtra("vitorias", pilotStats.vitorias)
                intent.putExtra("podios", pilotStats.podios)
                intent.putExtra("pontos", pilotStats.pontos)
                holder.itemView.context.startActivity(intent)
            }
        }

        override fun getItemCount() = pilotStatsList.size
    }


    data class PilotStats(val nome: String, val corridas: Int, val vitorias: Int, val podios: Int, val pontos: Int)

    private lateinit var pilotStatsList: List<PilotStats>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        pilotStatsList = listOf(
            PilotStats("Max Verstappen", 18, 7, 11, 331),
            PilotStats("Lando Norris", 18, 3, 11, 279),
            PilotStats("Charles Leclerc", 18, 2, 9, 245),
            PilotStats("Oscar Piastri", 18, 2, 7, 237),
            PilotStats("Lewis Hamilton", 18, 2, 4, 174)
        )


        val recyclerView: RecyclerView = findViewById(R.id.listaPilotos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = PilotStatsAdapter(pilotStatsList)
        recyclerView.adapter = adapter

    }

}
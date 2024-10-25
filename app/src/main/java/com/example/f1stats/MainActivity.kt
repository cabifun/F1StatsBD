package com.example.f1stats

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    class PilotStatsAdapter(private val pilotStatsList: List<Piloto>) : RecyclerView.Adapter<PilotStatsAdapter.ViewHolder>() {

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

    private lateinit var pilotoViewModel: PilotoViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.listaPilotos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        pilotoViewModel = ViewModelProvider(this)[PilotoViewModel::class.java]

        pilotoViewModel.todosPilotos.observe(this, Observer { pilotos ->
            pilotos?.let {
                val adapter = PilotStatsAdapter(it)
                recyclerView.adapter = adapter
            }
        })
    }
}

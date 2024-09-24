package com.example.f1stats

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalhesPilotoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes_piloto)

        val nomePiloto = intent.getStringExtra("nomePiloto")
        val corridas = intent.getIntExtra("corridas", 0)
        val vitorias = intent.getIntExtra("vitorias", 0)
        val podios = intent.getIntExtra("podios", 0)
        val pontos = intent.getIntExtra("pontos", 0)


        findViewById<TextView>(R.id.nomePiloto).text = nomePiloto
        findViewById<TextView>(R.id.corridasPiloto).text = "Corridas: $corridas"
        findViewById<TextView>(R.id.vitoriasPiloto).text = "Vitórias: $vitorias"
        findViewById<TextView>(R.id.podiosPiloto).text = "Pódios: $podios"
        findViewById<TextView>(R.id.pontosPiloto).text = "Pontos: $pontos"

        val imagemPiloto: ImageView = findViewById(R.id.imagemPiloto)
        imagemPiloto.setImageResource(getPilotoImageResource(nomePiloto))

    }

    private fun getPilotoImageResource(nomePiloto: String?): Int {
        return when (nomePiloto) {
            "Max Verstappen" -> R.drawable.verstappen
            "Lando Norris" -> R.drawable.norris
            "Charles Leclerc" -> R.drawable.leclerc
            "Oscar Piastri" -> R.drawable.piastri
            "Lewis Hamilton" -> R.drawable.hamilton
            else -> R.drawable.f1logo // Use uma imagem padrão se o piloto não for encontrado
        }
    }

}
package com.example.piedrapapeltijera

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.piedrapapelotijera.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var playerScore = 0
    private var computerScore = 0

    private lateinit var playerScoreText: TextView
    private lateinit var computerScoreText: TextView
    private lateinit var resultText: TextView
    private lateinit var computerChoiceText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Inicialización de los componentes
        playerScoreText = findViewById(R.id.playerScoreLabel)
        computerScoreText = findViewById(R.id.computerScoreLabel)
        resultText = findViewById(R.id.gameResult)
        computerChoiceText = findViewById(R.id.computerChoice)

        // Configuración de botones
        val btnPiedra: Button = findViewById(R.id.btnPiedra)
        val btnPapel: Button = findViewById(R.id.btnPapel)
        val btnTijera: Button = findViewById(R.id.btnTijera)

        btnPiedra.setOnClickListener { playGame("Piedra") }
        btnPapel.setOnClickListener { playGame("Papel") }
        btnTijera.setOnClickListener { playGame("Tijera") }
    }

    private fun playGame(playerChoice: String) {
        val choices = listOf("Piedra", "Papel", "Tijera")
        val computerChoice = choices.random()

        // Mostrar la elección de la computadora
        computerChoiceText.text = "La computadora eligió: $computerChoice"

        // Determinar el resultado
        val result = when {
            playerChoice == computerChoice -> "¡Empate!"
            playerChoice == "Piedra" && computerChoice == "Tijera" -> "¡Ganaste!"
            playerChoice == "Papel" && computerChoice == "Piedra" -> "¡Ganaste!"
            playerChoice == "Tijera" && computerChoice == "Papel" -> "¡Ganaste!"
            else -> "¡Perdiste!"
        }

        // Actualizar el resultado en la interfaz
        resultText.text = result
        if (result == "¡Ganaste!") {
            playerScore++
        } else if (result == "¡Perdiste!") {
            computerScore++
        }

        // Actualizar las puntuaciones
        playerScoreText.text = "Jugador: $playerScore"
        computerScoreText.text = "Computadora: $computerScore"
    }
}

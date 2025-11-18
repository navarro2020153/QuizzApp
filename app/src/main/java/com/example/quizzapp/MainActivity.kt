package com.example.quizzapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // --- Views ---
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button
    private lateinit var tvQuestion: TextView
    private lateinit var tvProgress: TextView
    private lateinit var tvScore: TextView   // NUEVO

    // --- Modelo de pregunta ---
    data class Question(
        val text: String,
        val isAnswerTrue: Boolean
    )

    // --- Banco de preguntas ---
    private val questions = listOf(
        Question("Android fue creado por Google.", true),
        Question("Kotlin es un lenguaje exclusivo de Android.", false),
        Question("XML se usa para definir layouts en Android.", true),
        Question("Un Toast es un tipo de layout.", false),
        Question("AppCompatActivity es una clase de soporte para Activities.", true)
    )

    // --- Estado del quiz ---
    private var currentIndex = 0
    private var score = 0
    private var alreadyAnswered = false
    private var quizFinished = false  // Para controlar reinicio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Vinculamos views
        btnTrue = findViewById(R.id.btn_true)
        btnFalse = findViewById(R.id.btn_false)
        btnNext = findViewById(R.id.btn_next)
        tvQuestion = findViewById(R.id.tv_question)
        tvProgress = findViewById(R.id.tv_progress)
        tvScore = findViewById(R.id.tv_score)

        // Mostramos la primera pregunta
        updateQuestion()
        updateScore()

        // --- Listeners de botones ---
        btnTrue.setOnClickListener {
            checkAnswer(true)
        }

        btnFalse.setOnClickListener {
            checkAnswer(false)
        }

        btnNext.setOnClickListener {
            if (quizFinished) {
                // Si ya terminó, el botón sirve para reiniciar
                restartQuiz()
            } else {
                goToNextQuestion()
            }
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (alreadyAnswered) {
            Toast.makeText(this, "Ya respondiste esta pregunta.", Toast.LENGTH_SHORT).show()
            return
        }

        val correctAnswer = questions[currentIndex].isAnswerTrue

        if (userAnswer == correctAnswer) {
            score++
            Toast.makeText(this, "¡Correcto! 😃", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Incorrecto ❌", Toast.LENGTH_SHORT).show()
        }

        // Actualiza el puntaje visible
        updateScore()

        // Marca como contestada y desactiva botones
        alreadyAnswered = true
        setAnswerButtonsEnabled(false)
    }

    private fun goToNextQuestion() {
        if (currentIndex < questions.size - 1) {
            currentIndex++
            alreadyAnswered = false
            updateQuestion()
            setAnswerButtonsEnabled(true)

            // Si estamos en la última pregunta, cambia el texto del botón
            if (currentIndex == questions.size - 1) {
                btnNext.text = "Finalizar"
            } else {
                btnNext.text = "Siguiente"
            }
        } else {
            // Quiz terminado
            Toast.makeText(
                this,
                "Quiz terminado. Puntaje: $score de ${questions.size}",
                Toast.LENGTH_LONG
            ).show()

            quizFinished = true
            btnNext.text = "Reiniciar"
            setAnswerButtonsEnabled(false)
        }
    }

    private fun updateQuestion() {
        val question = questions[currentIndex]
        tvQuestion.text = question.text
        tvProgress.text = "Pregunta ${currentIndex + 1} de ${questions.size}"
    }

    private fun updateScore() {
        tvScore.text = "Puntaje: $score"
    }

    private fun setAnswerButtonsEnabled(enabled: Boolean) {
        btnTrue.isEnabled = enabled
        btnFalse.isEnabled = enabled
    }

    private fun restartQuiz() {
        currentIndex = 0
        score = 0
        alreadyAnswered = false
        quizFinished = false

        btnNext.text = "Siguiente"
        setAnswerButtonsEnabled(true)
        updateQuestion()
        updateScore()
    }
}

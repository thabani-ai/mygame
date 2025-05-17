package vcmsa.ci.footballquiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "Cristiano Ronaldo has won more Balloon d'Ors than Messi.",
        "Brazil has won the most FIFA World Cups.",
        "The Premier League is older than La Liga.",
        "A football match lasts 90 minutes.",
        "Lionel Messi plays for Inter Miami."
    )

    private val answers = arrayOf(false, true, false, true, true)

    private var currentIndex = 0
    private var score = 0

    private lateinit var questionTextView: TextView
    private lateinit var feedbackTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionTextView = findViewById(R.id.questionTextView)
        feedbackTextView = findViewById(R.id.feedbackTextView)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)

        showQuestion()

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            currentIndex++
            if (currentIndex < questions.size) {
                showQuestion()
            } else {
                // End of quiz
                val feedback = if (score >= 3) "Great job!" else "Keep practising!"
                questionTextView.text = "Quiz Finished! You scored $score out of ${questions.size}.\n$feedback"
                feedbackTextView.text = ""
                trueButton.isEnabled = false
                falseButton.isEnabled = false
                nextButton.isEnabled = false
            }
        }
    }

    private fun showQuestion() {
        questionTextView.text = questions[currentIndex]
        feedbackTextView.text = ""
    }

    @SuppressLint("SetTextI18n")
    private fun checkAnswer(userAnswer: Boolean) {
        val correct = answers[currentIndex] == userAnswer
        if (correct) {
            score++
            feedbackTextView.text = "Correct!"
        } else {
            feedbackTextView.text = "Incorrect."
        }
    }
}
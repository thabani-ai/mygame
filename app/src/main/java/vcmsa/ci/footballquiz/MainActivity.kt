package vcmsa.ci.footballquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import vcmsa.ci.footballquiz.R.id
import vcmsa.ci.footballquiz.R.layout


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        // When user clicks Start, open the QuizActivity
        val startButton = findViewById<Button>(id.startButton)
        startButton.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
    }
}

//REF: OPENAI CHATGPT
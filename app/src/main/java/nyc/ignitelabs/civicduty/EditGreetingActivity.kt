package nyc.ignitelabs.civicduty

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EditGreetingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_greeting)

        intent?.also {
            val greetingInputView = findViewById<TextView>(R.id.greeting_input)
            greetingInputView.text = intent.getCharSequenceExtra(
                    Intent.EXTRA_TEXT)
        }

        val doneButton = findViewById<Button>(R.id.done_button)
        doneButton.setOnClickListener {
            val greetingInputView = findViewById<TextView>(R.id.greeting_input)

            Intent(this, MainActivity::class.java)
                    .putExtra(Intent.EXTRA_TEXT, greetingInputView.text)
                    .also {
                        setResult(Activity.RESULT_OK, it)
                        finish()
                    }
        }
    }
}

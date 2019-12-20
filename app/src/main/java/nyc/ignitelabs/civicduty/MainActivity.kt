package nyc.ignitelabs.civicduty

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editButton = findViewById<Button>(R.id.edit_button)
        editButton.setOnClickListener {
            val greetingTextView = findViewById<TextView>(R.id.greeting_text)

            Intent(this, EditGreetingActivity::class.java)
                    .putExtra(Intent.EXTRA_TEXT, greetingTextView.text)
                    .also { intent ->
                        startActivityForResult(intent, GET_GREETING_REQUEST)
                    }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int,
                                  data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when {
            requestCode == GET_GREETING_REQUEST && resultCode == Activity.RESULT_OK -> handleGreetingRequest(
                    data)
        }
    }

    private fun handleGreetingRequest(data: Intent?) {
        data?.also { intent ->
            val newGreeting = intent.getCharSequenceExtra(Intent.EXTRA_TEXT)
            val greetingTextView = findViewById<TextView>(R.id.greeting_text)

            greetingTextView.text = newGreeting
        }
    }

    companion object {
        internal const val GET_GREETING_REQUEST = 1
    }
}

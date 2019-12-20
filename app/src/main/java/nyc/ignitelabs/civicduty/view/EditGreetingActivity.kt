package nyc.ignitelabs.civicduty.view

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit_greeting.*
import nyc.ignitelabs.civicduty.R
import nyc.ignitelabs.civicduty.intent.GreetingIntent

class EditGreetingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_edit_greeting)

        intent?.also {
            greeting_input.text = Editable.Factory()
                .newEditable(
                    it.getStringExtra(GreetingIntent.EXTRA_TEXT_NAME)
                )
        }

        done_button.setOnClickListener {
            setResult(Activity.RESULT_OK,
                GreetingIntent.withExtraText(greeting_input.text.toString(),
                    this@EditGreetingActivity, MainActivity::class.java))
            finish()
        }
    }
}

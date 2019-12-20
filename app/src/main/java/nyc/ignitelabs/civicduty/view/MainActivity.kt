package nyc.ignitelabs.civicduty.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import nyc.ignitelabs.civicduty.R
import nyc.ignitelabs.civicduty.intent.GreetingIntent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        edit_button.setOnClickListener {
            startActivityForResult(
                GreetingIntent.withExtraText(
                    greeting_text.text.toString(),
                    this@MainActivity,
                    EditGreetingActivity::class.java
                ), GreetingIntent.REQUEST_CODE
            )
        }
    }

    override fun onActivityResult(
        requestCode: Int, resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode != Activity.RESULT_OK) {
            return
        }

        when (requestCode) {
            GreetingIntent.REQUEST_CODE ->
                greeting_text.text = data?.getStringExtra(
                    GreetingIntent.EXTRA_TEXT_NAME)
        }
    }
}

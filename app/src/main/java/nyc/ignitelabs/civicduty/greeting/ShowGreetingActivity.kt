package nyc.ignitelabs.civicduty.greeting

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_show_greeting.*
import nyc.ignitelabs.civicduty.R

class ShowGreetingActivity : AppCompatActivity() {
    private val vm: GreetingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_show_greeting)

        vm.greeting.value = greeting_text.text.toString()
        vm.greeting.observe(this, Observer<String> {
            greeting_text.text = it
        })

        edit_button.setOnClickListener {
            startActivity(
                GreetingIntent.startEdit(this@ShowGreetingActivity, EditGreetingActivity::class.java)
            )
        }
    }
}

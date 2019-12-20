package nyc.ignitelabs.civicduty.greeting

import android.os.Bundle
import android.text.Editable
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_edit_greeting.*
import nyc.ignitelabs.civicduty.R

class EditGreetingActivity : AppCompatActivity() {
    private val vm: GreetingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_edit_greeting)

        val greetingObserver = Observer<String> {
            greeting_input.text = Editable.Factory().newEditable(it)
        }

        vm.greeting.observe(this, greetingObserver)

        done_button.setOnClickListener {
            vm.greeting.value = greeting_input.text.toString()
            finish()
        }
    }
}

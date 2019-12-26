package nyc.ignitelabs.civicduty.greeting

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_greeting.*
import nyc.ignitelabs.civicduty.R

class GreetingActivity : AppCompatActivity() {
    private val vm: GreetingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_greeting)

        if (savedInstanceState != null) {
            return
        }

        vm.showEditFragment.observe(this, Observer {
            if (it) {
                editGreeting()
            } else {
                showGreeting()
            }
        })
    }

    private fun editGreeting() {
        val editFragment = EditGreetingFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(activity_greeting.id, editFragment)
            addToBackStack(null)
            commit()
        }
    }

    private fun showGreeting() {
        val showFragment = ShowGreetingFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(activity_greeting.id, showFragment)
            addToBackStack(null)
            commit()
        }

    }
}

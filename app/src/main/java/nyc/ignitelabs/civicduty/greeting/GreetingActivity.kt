package nyc.ignitelabs.civicduty.greeting

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_greeting.*
import nyc.ignitelabs.civicduty.R

class GreetingActivity : AppCompatActivity(),
    ShowGreetingFragment.OnEditGreetingListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_greeting)

        if (savedInstanceState != null) {
            return
        }

        val showFragment = ShowGreetingFragment()
        supportFragmentManager.beginTransaction().apply {
            add(activity_greeting.id, showFragment)
            commit()
        }
    }

    override fun onEditGreeting(v: View) {
        val editFragment = EditGreetingFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(activity_greeting.id, editFragment)
            addToBackStack(null)
            commit()
        }
    }
}

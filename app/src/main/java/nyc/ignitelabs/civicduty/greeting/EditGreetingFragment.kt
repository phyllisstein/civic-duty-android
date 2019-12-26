package nyc.ignitelabs.civicduty.greeting

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_edit_greeting.*
import nyc.ignitelabs.civicduty.R

class EditGreetingFragment : Fragment() {
    private val vm: GreetingViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_edit_greeting, container, false)
    }

    override fun onStart() {
        super.onStart()

        vm.greeting.observe(this, Observer {
            greeting_input.text = Editable.Factory().newEditable(it)
        })

        done_button.setOnClickListener {
            vm.setGreeting(greeting_input.text.toString())
            vm.toggleEditFragment()
        }
    }
}

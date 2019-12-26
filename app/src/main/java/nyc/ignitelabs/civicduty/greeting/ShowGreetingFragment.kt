package nyc.ignitelabs.civicduty.greeting

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_show_greeting.*
import nyc.ignitelabs.civicduty.R

class ShowGreetingFragment : Fragment() {
    private lateinit var listener: OnEditGreetingListener

    private val vm: GreetingViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_show_greeting, container,
                                false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            listener = context as OnEditGreetingListener
        } catch (ex: Exception) {
            throw ClassCastException("$context must implement OnEditGreetingListener")
        }
    }

    override fun onStart() {
        super.onStart()

        if (vm.greeting.value == null) {
            vm.setGreeting(greeting_text.text.toString())
        }

        vm.greeting.observe(this, Observer {
            greeting_text.text = it
        })

        edit_button.setOnClickListener(listener::onEditGreeting::invoke)
    }

    interface OnEditGreetingListener {
        fun onEditGreeting(v: View)
    }
}

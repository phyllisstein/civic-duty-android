package nyc.ignitelabs.civicduty.greeting

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class GreetingViewModel : ViewModel() {
    private val _greeting: MutableLiveData<String> by lazy { MutableLiveData() }

    var greeting: String?
        get() = _greeting.value
        set(value) {
            _greeting.value = value
        }

    fun observeGreeting(owner: LifecycleOwner, observer: Observer<String>) {
        _greeting.observe(owner, observer)
    }
}

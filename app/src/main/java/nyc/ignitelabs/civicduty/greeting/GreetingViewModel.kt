package nyc.ignitelabs.civicduty.greeting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GreetingViewModel : ViewModel() {
    private val _greeting: MutableLiveData<String> = MutableLiveData()

    val greeting: LiveData<String>
        get() = _greeting

    fun setGreeting(greeting: String) {
        _greeting.value = greeting
    }
}

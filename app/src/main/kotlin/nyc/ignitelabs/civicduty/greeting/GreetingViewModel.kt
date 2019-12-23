package nyc.ignitelabs.civicduty.greeting

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GreetingViewModel : ViewModel() {
    val greeting: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}

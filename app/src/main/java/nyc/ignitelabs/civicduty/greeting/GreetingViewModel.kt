package nyc.ignitelabs.civicduty.greeting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GreetingViewModel : ViewModel() {
    private val _greeting: MutableLiveData<String> = MutableLiveData()

    private val _showEditFragment: MutableLiveData<Boolean> = MutableLiveData(false)

    val greeting: LiveData<String>
        get() = _greeting

    val showEditFragment: LiveData<Boolean>
        get() = _showEditFragment

    fun setGreeting(greeting: String) {
        _greeting.value = greeting
    }

    fun toggleEditFragment() {
        _showEditFragment.value = _showEditFragment.value == null || _showEditFragment.value == false
    }
}

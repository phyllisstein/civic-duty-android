package nyc.ignitelabs.civicduty.greeting

import android.content.Context
import android.content.Intent

object GreetingIntent {
    fun startEdit(sender: Context, receiver: Class<*>): Intent =
        Intent().setClass(sender, receiver)
}

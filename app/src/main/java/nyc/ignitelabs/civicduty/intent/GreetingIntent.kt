package nyc.ignitelabs.civicduty.intent

import android.content.Context
import android.content.Intent
import android.text.Spannable

object GreetingIntent {
    const val EXTRA_TEXT_NAME = "GREETING_INTENT_EXTRA_TEXT"

    const val REQUEST_CODE = 1

    fun withExtraText(extraText: String, sender: Context,
                      receiver: Class<*>): Intent =
        Intent()
            .setClass(sender, receiver)
            .putExtra(EXTRA_TEXT_NAME, extraText)
}

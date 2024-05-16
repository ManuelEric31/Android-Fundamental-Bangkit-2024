package com.dicoding.mybroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log

class SmsReceiver : BroadcastReceiver() {

    companion object {
        private val TAG = SmsReceiver::class.java.simpleName
    }

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        if (intent.action == Telephony.Sms.Intents.SMS_RECEIVED_ACTION) {

//            Telephony.Sms.Intents untuk melakukan pemrosesan SMS
//            Untuk memperoleh obyek dari kelas SmsMessage, yaitu dengan menggunakan metode getMessagesFromIntent()
            val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
            for (message in messages) {
                val senderNum = message.originatingAddress
                val body = message.messageBody
                Log.d(TAG, "senderNum: $senderNum; message: $message")
                val showSmsIntent = Intent(context, SmsReceiverActivity::class.java)

//                Flag pada showSmsIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); akan menjalankan Activity pada task yang berbeda.
                showSmsIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                showSmsIntent.putExtra(SmsReceiverActivity.EXTRA_SMS_NO, senderNum)
                showSmsIntent.putExtra(SmsReceiverActivity.EXTRA_SMS_MESSAGE, body)
                context.startActivity(showSmsIntent)
            }
        }
    }
}
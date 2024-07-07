package com.alpharays.mymedprofilefma

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import com.alpharays.mymedprofilefma.profilefma.profile.ProfileActivity

@SuppressLint("StaticFieldLeak")
object MedProfileFmaRouter {
    const val AUTH_TOKEN_SHARED_PREF = "authTokenSharedPrefHighPriority"
    const val AUTH_TOKEN_KEY = "authToken"
    lateinit var context: Context

    fun startDummyActivity(context: Context) {
        // Start the DummyActivity
        val intent = Intent(context, ProfileActivity::class.java)
        context.startActivity(intent)
    }


    fun initiateMedCommRouter(context: Context) {
        this.context = context
    }
}
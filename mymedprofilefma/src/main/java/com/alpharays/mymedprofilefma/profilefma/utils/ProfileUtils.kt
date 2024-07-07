package com.alpharays.mymedprofilefma.profilefma.utils

import android.content.Context
import com.alpharays.mymedprofilefma.MedProfileFmaRouter

class ProfileUtils {
    companion object {
        fun setAuthToken(context: Context, token: String) {
            val authTokenSharedPref = context.getSharedPreferences(
                MedProfileFmaRouter.AUTH_TOKEN_SHARED_PREF,
                Context.MODE_PRIVATE
            )
            authTokenSharedPref.edit().putString(MedProfileFmaRouter.AUTH_TOKEN_KEY, token).apply()
        }

        fun getAuthToken(context: Context): String {
            val authTokenSharedPref = context.getSharedPreferences(
                MedProfileFmaRouter.AUTH_TOKEN_SHARED_PREF,
                Context.MODE_PRIVATE
            )
            return authTokenSharedPref.getString(MedProfileFmaRouter.AUTH_TOKEN_KEY, null).toString()
        }








    }
}
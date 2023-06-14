package com.capstone.smartgrocerylist.utils

import android.content.Context
import android.content.SharedPreferences

object Preference {
    fun initPref(context: Context, name: String): SharedPreferences {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    private fun String.editorPreference(context: Context): SharedPreferences.Editor {
        val sharedPref = context.getSharedPreferences(this, Context.MODE_PRIVATE)
        return sharedPref.edit()
    }

    fun saveToken(token: String, context: Context) {
        val editor = "onSignIn".editorPreference(context)
        editor.putString("token", token)
        editor.apply()
    }

    fun logOut(context: Context) {
        val editor = "onSignIn".editorPreference(context)
        editor.remove("token")
        editor.remove("status")
        editor.apply()
    }
}
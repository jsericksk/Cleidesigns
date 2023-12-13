package com.kproject.cleidesigns.presentation.commom.extensions

import android.net.Uri
import com.google.gson.Gson

/**
 * Useful for converting data class to Json and being able to transfer data with Navigation.
 */
fun <T> String.fromJson(type: Class<T>): T {
    return Gson().fromJson(Uri.decode(this), type)
}

fun <T> T.toJson(): String {
    return Uri.encode(Gson().toJson(this))
}
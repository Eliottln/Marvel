package com.fr.iem.marvel.extensions

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> Gson.parse(input: String): T {
    return this.fromJson(input, object : TypeToken<T>() {}.type)
}

package com.fr.iem.marvel.manager.service

import com.fr.iem.marvel.extensions.hashMD5
import com.fr.iem.marvel.manager.resource.ResourceManagerImpl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*


class ApiInterceptor : Interceptor {

    private val publicKey = ResourceManagerImpl().readProperties("PUBLIC_KEY")
    private val privateKey = ResourceManagerImpl().readProperties("PRIVATE_KEY")


    override fun intercept(chain: Interceptor.Chain): Response {
        val timestamp = Date().time.toString()
        val hash = timestamp.plus(privateKey).plus(publicKey).hashMD5()

        val url = chain.request()
            .url()
            .newBuilder()
            .addQueryParameter("ts", timestamp)
            .addQueryParameter("apikey", publicKey)
            .addQueryParameter("hash", hash)
            .build()
        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }

}
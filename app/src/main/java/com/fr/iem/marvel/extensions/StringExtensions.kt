package com.fr.iem.marvel.extensions

import java.math.BigInteger
import java.security.MessageDigest

fun String.hashMD5(): String {
    return BigInteger(
        1,
        MessageDigest.getInstance("MD5").digest(this.toByteArray())
    ).toString(16).padStart(32, '0')
}
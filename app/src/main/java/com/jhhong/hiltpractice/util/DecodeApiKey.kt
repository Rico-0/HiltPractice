package com.jhhong.hiltpractice.util

import com.jhhong.hiltpractice.data.Constants
import java.net.URLDecoder

object DecodeApiKey {
    fun decode() : String {
        return URLDecoder.decode(Constants.AUTH_KEY, "utf-8")
    }
}
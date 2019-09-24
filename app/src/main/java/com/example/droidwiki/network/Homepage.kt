package com.example.droidwiki.network

import com.example.droidwiki.network.WikiApi

class Homepage(private val api: WikiApi) {
  fun get() = api.getHomepage()
}
package com.example.droidwiki.network

import com.example.droidwiki.network.WikiApi

class Wiki(private val api: WikiApi) {
  fun search(query: String) = api.search(query)
}

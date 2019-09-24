package com.example.droidwiki.ui.homepage

import com.example.droidwiki.model.WikiHomepage

interface HomepageView {

  fun displayLoading()

  fun dismissLoading()

  fun displayHomepage(result: WikiHomepage)

  fun displayError(error: String?)
}
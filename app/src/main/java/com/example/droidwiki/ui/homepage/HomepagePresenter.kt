package com.example.droidwiki.ui.homepage

import com.example.droidwiki.ui.homepage.HomepageView

interface HomepagePresenter {
  fun setView(homepageView: HomepageView)

  fun loadHomepage()
}
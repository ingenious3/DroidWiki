package com.example.droidwiki.ui.splashscreen

import android.app.Activity
import android.os.Bundle
import com.example.droidwiki.R

import com.example.droidwiki.ui.homepage.HomepageActivity
import com.example.droidwiki.utils.start

class Splashscreen : Activity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    HomepageActivity::class.start(this, true)
  }
}
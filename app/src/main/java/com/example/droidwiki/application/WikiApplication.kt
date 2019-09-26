package com.example.droidwiki.application

import android.app.Application
import com.example.droidwiki.dagger.AppComponent
import com.example.droidwiki.dagger.AppModule
import com.example.droidwiki.dagger.DaggerAppComponent

class WikiApplication : Application() {

  lateinit var wikiComponent : AppComponent

  override fun onCreate() {
    super.onCreate()
    wikiComponent = initDagger(this)
  }

  private fun initDagger( app : WikiApplication) : AppComponent {
    return DaggerAppComponent.builder().appModule(AppModule(app)).build()
  }
}
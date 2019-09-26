package com.example.droidwiki.dagger

import com.example.droidwiki.ui.homepage.HomepageActivity
import com.example.droidwiki.ui.search.SearchActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, PresenterModule::class, NetworkModule::class, WikiModule::class])
interface AppComponent {

    fun inject(target : HomepageActivity)
    fun inject(target : SearchActivity)

}

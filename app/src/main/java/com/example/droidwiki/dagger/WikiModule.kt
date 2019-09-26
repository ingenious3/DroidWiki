package com.example.droidwiki.dagger

import com.example.droidwiki.network.Homepage
import com.example.droidwiki.network.Wiki
import com.example.droidwiki.network.WikiApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WikiModule {

    @Provides
    @Singleton
    fun provideHomepage(api: WikiApi) = Homepage(api)

    @Provides
    @Singleton
    fun provideWiki(api: WikiApi) = Wiki(api)

}
package com.example.droidwiki.dagger

import com.example.droidwiki.network.Homepage
import com.example.droidwiki.network.Wiki
import com.example.droidwiki.ui.homepage.HomepagePresenter
import com.example.droidwiki.ui.homepage.HomepagePresenterImpl
import com.example.droidwiki.ui.search.EntryPresenter
import com.example.droidwiki.ui.search.EntryPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Singleton
    @Provides
    fun provideHomePagePresenter(homePage : Homepage) : HomepagePresenter = HomepagePresenterImpl(homePage)

    @Singleton
    @Provides
    fun provideEntryPresenter(wiki : Wiki) : EntryPresenter = EntryPresenterImpl(wiki)

}
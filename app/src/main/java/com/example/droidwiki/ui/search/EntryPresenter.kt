package com.example.droidwiki.ui.search

import com.example.droidwiki.ui.search.EntryView

interface EntryPresenter {
  fun setView(entryView: EntryView)

  fun getEntry(query: String)
}
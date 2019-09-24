package com.example.droidwiki.ui.search

import com.example.droidwiki.model.Entry

interface EntryView {
  fun displayLoading()

  fun dismissLoading()

  fun displayEntries(results: List<Entry>)

  fun displayError(error: String?)
}
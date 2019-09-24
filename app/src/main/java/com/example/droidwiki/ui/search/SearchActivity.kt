package com.example.droidwiki.ui.search

import android.app.Activity
import android.os.Bundle

import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_search.*
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.droidwiki.R
import com.example.droidwiki.model.Entry
import com.example.droidwiki.ui.search.EntryAdapter
import com.example.droidwiki.ui.search.EntryPresenter
import com.example.droidwiki.ui.search.EntryPresenterImpl
import com.example.droidwiki.ui.search.EntryView
import com.example.droidwiki.utils.errorDialog


class SearchActivity : Activity(), EntryView {

  private val presenter: EntryPresenter = EntryPresenterImpl()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_search)

    actionBar?.setHomeAsUpIndicator(R.drawable.ic_home)
    actionBar?.setDisplayHomeAsUpEnabled(true)

    results_rv.layoutManager = LinearLayoutManager(this)

    presenter.setView(this)

  }

  // Create the menu entries
  override fun onOptionsItemSelected(item: MenuItem) =
      when (item.itemId) {
        android.R.id.home -> {
          onBackPressed()
          true
        }
        else -> {
          super.onOptionsItemSelected(item)
        }
      }

  // Bind menu entries with their actions
  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.search, menu)

    menu?.findItem(R.id.search)?.let { menuItem ->
      (menuItem.actionView as? SearchView)?.apply {
        setOnQueryTextListener(object : SearchView.OnQueryTextListener {
          override fun onQueryTextChange(query: String) = true
          override fun onQueryTextSubmit(query: String?): Boolean {
            presenter.getEntry(query ?: "")
            return true
          }
        })

        queryHint = getString(R.string.search_hint)
      }

      menuItem.expandActionView()
    }

    return super.onCreateOptionsMenu(menu)
  }

  // Implementation of EntryView

  override fun displayLoading() {
    wait_progress_bar.post {
      wait_progress_bar.visibility = View.VISIBLE
      results_rv.visibility = View.GONE
    }
  }

  override fun dismissLoading() {
    wait_progress_bar.post {
      wait_progress_bar.visibility = View.GONE
      results_rv.visibility = View.VISIBLE
    }
  }

  override fun displayEntries(results: List<Entry>) {
    results_rv.post {
      results_rv.adapter = EntryAdapter(this, results)
    }
  }

  override fun displayError(error: String?) {
    Log.e("ERROR", error)
    R.string.error.errorDialog(this)
  }
}

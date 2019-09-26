package com.example.droidwiki.ui.homepage

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.droidwiki.R
import com.example.droidwiki.application.WikiApplication
import com.example.droidwiki.model.WikiHomepage
import com.example.droidwiki.ui.search.SearchActivity
import com.example.droidwiki.utils.errorDialog
import com.example.droidwiki.utils.parseHtml
import com.example.droidwiki.utils.start

import kotlinx.android.synthetic.main.activity_homepage.*
import javax.inject.Inject

class HomepageActivity : Activity(), HomepageView {

   @Inject lateinit var presenter: HomepagePresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_homepage)

    (application as WikiApplication).wikiComponent.inject(this)

    presenter.setView(this)
    presenter.loadHomepage()
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.homepage, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem) =
      when (item.itemId) {
        R.id.search -> {
          SearchActivity::class.start(this)
          true
        }

        else -> {
          super.onOptionsItemSelected(item)
        }
      }

  // Implementation of HomepageView

  override fun displayLoading() {
    wait_progress_bar.post {
      wait_progress_bar.visibility = View.VISIBLE
      homepage_sv.visibility = View.GONE
    }
  }

  override fun dismissLoading() {
    wait_progress_bar.post {
      wait_progress_bar.visibility = View.GONE
      homepage_sv.visibility = View.VISIBLE
    }
  }

  override fun displayHomepage(result: WikiHomepage) {
    homepage_tv.post {
      homepage_tv.text = result.htmlContent.parseHtml()
    }
  }

  override fun displayError(error: String?) {
    Log.e("ERROR", error)
    runOnUiThread {
      R.string.error.errorDialog(this)
    }
  }
}

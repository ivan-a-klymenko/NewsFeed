package ru.bk.klim9.newsfeed.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ru.bk.klim9.newsfeed.R
import ru.bk.klim9.newsfeed.adapter.NewsArticlesAdapter
import ru.bk.klim9.newsfeed.model.ViewState
import ru.bk.klim9.newsfeed.ui.base.BaseActivity
import ru.bk.klim9.newsfeed.ui.viewmodel.NewsArticleViewModel
import ru.bk.klim9.newsfeed.utils.getViewModel
import ru.bk.klim9.newsfeed.utils.observeNotNull
import ru.bk.klim9.newsfeed.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.empty_layout.*
import kotlinx.android.synthetic.main.progress_layout.*

class MainActivity : BaseActivity() {

    private val newsArticleViewModel by lazy { getViewModel<NewsArticleViewModel>() }

    /**
     * Starting point of the activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setting up RecyclerView and adapter
        newsList.setEmptyView(empty_view)
        newsList.setProgressView(progress_view)

        val adapter = NewsArticlesAdapter { toast("Clicked on item") }
        newsList.adapter = adapter
        newsList.layoutManager = LinearLayoutManager(this)

        // Update the UI on state change
        newsArticleViewModel.getNewsArticles().observeNotNull(this) { state ->
            when (state) {
                is ViewState.Success -> adapter.replaceItems(state.data)
                is ViewState.Loading -> newsList.showLoading()
                is ViewState.Error -> toast("Something went wrong ¯\\_(ツ)_/¯ => ${state.message}")
            }
        }

    }
}

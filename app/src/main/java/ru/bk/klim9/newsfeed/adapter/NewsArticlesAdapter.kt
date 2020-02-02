package ru.bk.klim9.newsfeed.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.bk.klim9.newsfeed.R
import ru.bk.klim9.newsfeed.model.NewsAdapterEvent
import ru.bk.klim9.newsfeed.model.NewsArticles
import ru.bk.klim9.newsfeed.utils.inflate
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_news.view.*

/**
 * The News adapter to show the news in a list.
 */
class NewsArticlesAdapter(
        private val listener: (NewsAdapterEvent) -> Unit
) : RecyclerView.Adapter<NewsArticlesAdapter.NewsHolder>() {

    /**
     * List of news articles
     */
    private var newsArticles: List<NewsArticles> = emptyList()

    /**
     * Inflate the view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewsHolder(parent.inflate(R.layout.item_news))

    /**
     * Bind the view with the data
     */
    override fun onBindViewHolder(newsHolder: NewsHolder, position: Int) = newsHolder.bind(newsArticles[position], listener)

    /**
     * Number of items in the list to display
     */
    override fun getItemCount() = newsArticles.size

    /**
     * View Holder Pattern
     */
    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /**
         * Binds the UI with the data and handles clicks
         */
        fun bind(newsArticle: NewsArticles, listener: (NewsAdapterEvent) -> Unit) = with(itemView) {
            newsTitle.text = newsArticle.title
            newsAuthor.text = newsArticle.author
            //TODO: need to format date
            //tvListItemDateTime.text = getFormattedDate(newsArticle.publishedAt)
            newsPublishedAt.text = newsArticle.publishedAt
            Glide.with(context)
                    .load(newsArticle.urlToImage)
                    .apply(RequestOptions()
                            .placeholder(R.drawable.tools_placeholder)
                            .error(R.drawable.tools_placeholder)
                            .diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(newsImage)
            setOnClickListener { listener(NewsAdapterEvent.ClickEvent) }
        }

    }

    /**
     * Swap function to set new data on updating
     */
    fun replaceItems(items: List<NewsArticles>) {
        newsArticles = items
        notifyDataSetChanged()
    }
}
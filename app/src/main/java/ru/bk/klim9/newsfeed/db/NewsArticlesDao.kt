package ru.bk.klim9.newsfeed.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.bk.klim9.newsfeed.model.NewsArticles

/**
 * Defines access layer to news articles table
 */
@Dao
interface NewsArticlesDao {

    /**
     * Insert articles into the table
     */
    @Insert
    fun insertArticles(articles: List<NewsArticles>): List<Long>

    /**
     * Get all the articles from table
     */
    @Query("SELECT * FROM news_article")
    suspend fun getNewsArticles(): List<NewsArticles>
}
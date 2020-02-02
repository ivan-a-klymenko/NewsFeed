package ru.bk.klim9.newsfeed.api

import ru.bk.klim9.newsfeed.BuildConfig
import ru.bk.klim9.newsfeed.model.NewsSourceResponse
import retrofit2.http.GET

/**
 * Fetch all the latest news article from various news services
 * using the News API.
 */
interface NewsService {

    /**
     * Retrieves all the latest news article from Google news using News API.
     */
    @GET("articles?source=google-news&apiKey=${BuildConfig.NEWS_API_KEY}")
    suspend fun getNewsFromGoogle(): NewsSourceResponse

}

package ru.bk.klim9.newsfeed.model

import ru.bk.klim9.newsfeed.adapter.NewsArticlesAdapter

/**
 * Describes all the events originated from
 * [NewsArticlesAdapter].
 */
sealed class NewsAdapterEvent {

    /* Describes item click event  */
    object ClickEvent : NewsAdapterEvent()
}
package ru.bk.klim9.newsfeed.di

import android.app.Application
import ru.bk.klim9.newsfeed.db.NewsArticlesDao
import ru.bk.klim9.newsfeed.db.NewsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NewsDatabaseModule {

    @Singleton
    @Provides
    fun provideDb(app: Application): NewsDatabase = NewsDatabase.buildDefault(app)

    @Singleton
    @Provides
    fun provideUserDao(db: NewsDatabase): NewsArticlesDao = db.newsArticlesDao()
}
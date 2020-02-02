package ru.bk.klim9.newsfeed.db

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.bk.klim9.newsfeed.model.NewsArticles

@Database(
        entities = [NewsArticles::class],
        version = NewsDatabaseMigration.latestVersion
)
abstract class NewsDatabase : RoomDatabase() {

    /**
     * Get news article DAO
     */
    abstract fun newsArticlesDao(): NewsArticlesDao

    companion object {

        private const val databaseName = "news-db"

        fun buildDefault(context: Context) =
                Room.databaseBuilder(context, NewsDatabase::class.java, databaseName)
                        .addMigrations(*NewsDatabaseMigration.allMigrations)
                        .build()

        @VisibleForTesting
        fun buildTest(context: Context) =
                Room.inMemoryDatabaseBuilder(context, NewsDatabase::class.java)
                        .build()
    }
}
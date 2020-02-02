package ru.bk.klim9.newsfeed.di

import android.app.Application
import ru.bk.klim9.newsfeed.NewsApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            // Dagger support
            AndroidInjectionModule::class,

            // App
            NewsDatabaseModule::class,
            NewsServiceModule::class,
            ActivityModule::class,
            ViewModelModule::class
        ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(newsApp: NewsApp)
}

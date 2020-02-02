package ru.bk.klim9.newsfeed.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.bk.klim9.newsfeed.di.base.ViewModelFactory
import ru.bk.klim9.newsfeed.di.base.ViewModelKey
import ru.bk.klim9.newsfeed.ui.viewmodel.NewsArticleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Describes all the [ViewModel] which need to be
 * created using DI.
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsArticleViewModel::class)
    abstract fun bindNewsArticleViewModel(newsArticleViewModel: NewsArticleViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}

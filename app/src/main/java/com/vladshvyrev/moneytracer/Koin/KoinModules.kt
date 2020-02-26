package com.vladshvyrev.moneytracer.Koin



import com.vladshvyrev.moneytracer.Repository.network.CategoryDatabase
import com.vladshvyrev.moneytracer.Repository.network.RepositoryForCategory
import com.vladshvyrev.moneytracer.ui.fragments.ListOfCategoryFragment.DataAdapterForCategory
import com.vladshvyrev.moneytracer.ui.fragments.ListOfCategoryFragment.ListOfCategoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dbModule = module {
    single { CategoryDatabase.getInstance(
        context = get()
    )}
    factory { get<CategoryDatabase>().noteDao() }
}

val repositoryModule = module {
    single { RepositoryForCategory(get()) }
}

val uiModule = module {
    factory { DataAdapterForCategory() }
    viewModel { ListOfCategoryViewModel(get()) }
}
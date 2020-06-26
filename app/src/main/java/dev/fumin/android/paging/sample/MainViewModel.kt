package dev.fumin.android.paging.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.toLiveData

class MainViewModel : ViewModel() {

    private val factory = DataSourceFactory()
    val items: LiveData<PagedList<String>> = factory.toLiveData(10)

    fun refresh() {
        factory.dataSource.value?.invalidate()
    }

}

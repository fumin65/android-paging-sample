package dev.fumin.android.paging.sample

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

class DataSourceFactory : DataSource.Factory<String, String>() {

    val dataSource = MutableLiveData<SampleDataSource>()

    override fun create(): DataSource<String, String> {
        val source = SampleDataSource()
        dataSource.postValue(source)
        return source
    }

}

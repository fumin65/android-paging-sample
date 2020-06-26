package dev.fumin.android.paging.sample

import android.util.Log
import androidx.paging.PageKeyedDataSource
import java.util.*

class SampleDataSource : PageKeyedDataSource<String, String>() {

    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, String>
    ) {
        Log.d("test", "loadInitial")
        callback.onResult(random(params.requestedLoadSize), "before", "after")
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, String>) {
        Log.d("test", "loadAfter : ${params.key}, ${params.requestedLoadSize}")
        callback.onResult(random(params.requestedLoadSize), "after")
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, String>) {
        Log.d("test", "loadBefore : ${params.key}")
        callback.onResult(listOf("before"), null)
    }

    private fun random(size: Int): List<String> {
        return (1..size).map { UUID.randomUUID().toString() }
    }
}

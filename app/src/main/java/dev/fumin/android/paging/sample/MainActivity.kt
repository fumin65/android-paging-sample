package dev.fumin.android.paging.sample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = Adapter()
        list.adapter = adapter
        viewModel.items.observe(this, Observer {
            adapter.submitList(it)
        })

        btn.setOnClickListener {
            viewModel.refresh()
        }
    }
}

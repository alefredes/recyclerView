package com.example.alexisfredes.recyclerviewfredes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerFre.layoutManager = GridLayoutManager(this, 2)
        recyclerFre.adapter = ItemAdapter(getItems()) {
            val ft = supportFragmentManager.beginTransaction()
            val newFragment = ItemDialogFragment.newInstance(it)
            newFragment.show(ft, "dialog")
            Log.d("TAG", it.title)
        }
    }
}

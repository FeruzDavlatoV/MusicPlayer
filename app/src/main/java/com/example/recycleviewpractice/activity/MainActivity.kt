package com.example.recycleviewpractice.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewpractice.adapter.MainRecyclerViewAdapter
import com.example.recycleviewpractice.model.Music
import com.example.recycleviewpractice.R
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var mainRecyclerViewAdapter: MainRecyclerViewAdapter
    private lateinit var musicList: ArrayList<Music>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        musicList = ArrayList()

        for (i in 0..10){
            musicList.add(Music("Enrique Iglessis","Album 2022", R.drawable.img,R.raw.music_simple1))
        }

        //GridLayoutManager
//        mainRecyclerViewAdapter = MainRecyclerViewAdapter(musicList)
//        val mainRv = findViewById<RecyclerView>(R.id.rv_main)
//        mainRv.adapter = mainRecyclerViewAdapter
//        mainRv.layoutManager = GridLayoutManager(applicationContext, 2, GridLayoutManager.HORIZONTAL, false)
        val mainRv = findViewById<RecyclerView>(R.id.rv_main)

        mainRecyclerViewAdapter = MainRecyclerViewAdapter(musicList,MainRecyclerViewAdapter.ItemClickListener{
            startPlayerActivity(it)
        })
        mainRv.adapter = mainRecyclerViewAdapter
        mainRv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)



    }

    private fun startPlayerActivity(music: Music) {
        val intent = Intent(this,PlayerActivity::class.java)
        intent.putExtra("music", music)
        startActivity(intent)
    }

}
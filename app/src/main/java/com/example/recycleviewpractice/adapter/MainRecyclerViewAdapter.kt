package com.example.recycleviewpractice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewpractice.model.Music
import com.example.recycleviewpractice.R

class MainRecyclerViewAdapter(val musicList: ArrayList<Music>,private val itemClickListener: ItemClickListener):
    RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val music = musicList[position]


        holder.apply {
            albumText.text = music.album
            tittleText.text = music.tittle
            imageView.setImageResource(music.image)
        }

        holder.view.setOnClickListener{
            itemClickListener.onClick(music)
        }
    }

    override fun getItemCount(): Int = musicList.size

    class ItemClickListener(val callBack: (music:Music) -> Unit){
        fun onClick(music: Music) = callBack(music)
    }


    class ViewHolder(val view:View) : RecyclerView.ViewHolder(view){

        val imageView = view.findViewById<ImageView>(R.id.img_music)
        val tittleText = view.findViewById<TextView>(R.id.tv_title_music)
        val albumText = view.findViewById<TextView>(R.id.tv_album_music)

    }





}
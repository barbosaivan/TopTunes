package com.ivanbarbosa.toptunes.view.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ivanbarbosa.toptunes.R
import com.ivanbarbosa.toptunes.databinding.ItemArtistBinding
import com.ivanbarbosa.toptunes.enity.Artist
import com.ivanbarbosa.toptunes.utils.Validations
import java.util.*

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.view
* Create by Ivan Barbosa on 15/06/2023 at 7:13 p. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
class ArtistAdapter(private var artists: List<Artist>, private var listener: OnClickListener) :
    RecyclerView.Adapter<ArtistAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_artist, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artist = artists[position]
        with(holder) {
            setListener(artist)
            binding.nameArtists.text = artist.name
            binding.countListen.text = Validations.separateDigits(artist.listeners)
            binding.rank.text = (position + 1).toString()
            val imageUrl = Validations.getImageUrlBySize(artist.image, "medium")
            if (imageUrl != null) {
                Glide.with(context)
                    .load(imageUrl)
                    .diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.ALL)
                    .centerCrop()
                    .into(binding.imageArtist)
            }
        }
    }

    override fun getItemCount(): Int = artists.size

    fun setArtist(artists: List<Artist>) {
        this.artists = artists
        this.notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemArtistBinding.bind(view)
        fun setListener(artist: Artist) {
            with(binding.root) {
                setOnClickListener { listener.onClick(artist) }
            }
        }
    }
}
package com.ivanbarbosa.toptunes.view.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ivanbarbosa.toptunes.R
import com.ivanbarbosa.toptunes.databinding.ItemSongBinding
import com.ivanbarbosa.toptunes.enities.tracks.Track
import com.ivanbarbosa.toptunes.utils.Validations
import com.ivanbarbosa.toptunes.view.adapters.onClickListener.OnClickListenerTrack

/* 
* Project: TopTunes
* From: com.ivanbarbosa.toptunes.view.adapters
* Create by Ivan Barbosa on 16/06/2023 at 1:15 a. m.
* Linkedin: https://www.linkedin.com/in/ivanbarbosaortega/
*/
class TrackAdapter(private var tracks: List<Track>, private var listener: OnClickListenerTrack) :
    RecyclerView.Adapter<TrackAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_song, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val track = tracks[position]
        with(holder) {
            setListener(track)
            binding.nameSong.text = track.name
            binding.countPlay.text = Validations.separateDigits(track.playcount)
            val imageUrl = Validations.getImageUrlBySize(track.image, "medium")
            if (imageUrl != null) {
                Glide.with(context)
                    .load(imageUrl)
                    .diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.ALL)
                    .centerCrop()
                    .into(binding.imageSong)
            }
        }
    }

    override fun getItemCount(): Int = tracks.size

    fun setTrack(tracks: List<Track>) {
        this.tracks = tracks
        this.notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemSongBinding.bind(view)
        fun setListener(track: Track) {
            with(binding.root) {
                setOnClickListener { listener.onClick(track) }
            }
        }
    }
}
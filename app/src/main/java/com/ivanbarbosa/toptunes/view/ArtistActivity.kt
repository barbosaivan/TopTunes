package com.ivanbarbosa.toptunes.view

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.ivanbarbosa.toptunes.R
import com.ivanbarbosa.toptunes.databinding.ActivityArtistBinding
import com.ivanbarbosa.toptunes.enities.artists.Artist
import com.ivanbarbosa.toptunes.enities.tracks.Track
import com.ivanbarbosa.toptunes.utils.Validations
import com.ivanbarbosa.toptunes.view.adapters.TrackAdapter
import com.ivanbarbosa.toptunes.view.adapters.onClickListener.OnClickListenerTrack
import com.ivanbarbosa.toptunes.viewModel.ArtistViewModel

class ArtistActivity : AppCompatActivity(), OnClickListenerTrack {

    private lateinit var binding: ActivityArtistBinding
    private lateinit var trackAdapter: TrackAdapter
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var artistViewModel: ArtistViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val artist = getArtist()

        setUpViewData(artist!!)
        loadImage(artist)
        setUpRecycler()
        setUpViewModel()
        requestTrack(artist)
    }

    private fun getArtist() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        intent.extras?.getSerializable("artist", Artist::class.java)
    } else {
        intent.extras?.getSerializable("artist") as? Artist
    }

    private fun setUpViewData(artist: Artist) {
        binding.nameArtists.text = artist.name

        binding.btnSee.setOnClickListener {
            try {
                goToWebSite(artist.url)
            } catch (e: NullPointerException) {
                e.printStackTrace()
                Snackbar.make(
                    binding.root,
                    getString(R.string.error_url_inexistente),
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun loadImage(artist: Artist) {
        val imageUrl = Validations.getImageUrlBySize(artist.image, "mega")
        if (imageUrl != null) {
            Glide.with(this)
                .load(imageUrl)
                .diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.imageArtist)
        }
    }

    private fun setUpRecycler() {
        trackAdapter = TrackAdapter(mutableListOf(), this@ArtistActivity)
        gridLayout = GridLayoutManager(this, 1)
        binding.recyclerTracks.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = this@ArtistActivity.trackAdapter
        }
    }

    private fun setUpViewModel() {
        artistViewModel = ViewModelProvider(this)[ArtistViewModel::class.java]
        artistViewModel.getResult().observe(this) { artist ->
            trackAdapter.setTrack(artist.toptracks.track.sortedBy { it.attr.rank }.take(5))
        }

        artistViewModel.getSnackbarMsg().observe(this) { msgErr ->
            Snackbar.make(binding.root, msgErr, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun requestTrack(artist: Artist) {
        artistViewModel.getTrack(
            "artist.gettoptracks",
            artist.name,
            "cf2894b9c73a323e24f5c6a9aab1eb85",
            "json"
        )
    }

    private fun goToWebSite(url: String) {
        if (url.isEmpty()) {
            Snackbar.make(binding.root, getString(R.string.error_exist_url), Snackbar.LENGTH_LONG)
                .show()
        } else {
            val webSite = Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse(url)
            }
            try {
                startActivity(webSite)
            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
                Snackbar.make(
                    binding.root,
                    getString(R.string.error_accessing_browser),
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onClick(track: Track) {
        try {
            goToWebSite(track.url)
        } catch (e: NullPointerException) {
            e.printStackTrace()
            Snackbar.make(
                binding.root,
                getString(R.string.error_url_inexistente),
                Snackbar.LENGTH_LONG
            ).show()
        }
    }
}
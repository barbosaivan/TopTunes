package com.ivanbarbosa.toptunes.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.ivanbarbosa.toptunes.databinding.ActivityMainBinding
import com.ivanbarbosa.toptunes.entities.artists.Artist
import com.ivanbarbosa.toptunes.view.adapters.ArtistAdapter
import com.ivanbarbosa.toptunes.view.adapters.onClickListener.OnClickListener
import com.ivanbarbosa.toptunes.viewModel.MainViewModel

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var artistAdapter: ArtistAdapter
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecycler()
        setUpViewModel()
        requestArtist()
    }

    private fun setUpRecycler() {
        artistAdapter = ArtistAdapter(mutableListOf(), this@MainActivity)
        gridLayout = GridLayoutManager(this, 1)
        binding.recyclerArtists.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = this@MainActivity.artistAdapter
        }
    }

    private fun setUpViewModel() {
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.getResult().observe(this) { artist ->
            artistAdapter.setArtist(artist.topartists.artist.sortedByDescending { it.listeners }
                .take(10))
            binding.progressbar.visibility = View.GONE
        }

        mainViewModel.isLoaded().observe(this) { isLoaded ->
            binding.progressbar.visibility = if (!isLoaded) View.VISIBLE else View.GONE
        }

        mainViewModel.getSnackbarMsg().observe(this) { msgErr ->
            Snackbar.make(binding.root, msgErr, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun requestArtist() {
        mainViewModel.getArtist(
            "geo.gettopartists",
            "colombia",
            "cf2894b9c73a323e24f5c6a9aab1eb85",
            "json"
        )
    }

    override fun onClick(artist: Artist) {
        val intent = Intent(this, ArtistActivity::class.java)
        intent.putExtra("artist", artist)
        startActivity(intent)
    }

}
package com.cmesquita.technicaltest.justposts.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cmesquita.technicaltest.justposts.R
import com.cmesquita.technicaltest.justposts.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_JustPosts)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
package com.example.registrosuperherores

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registrosuperherores.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object{
        const val SUPERHERO_KEY = "etName"
        const val BITMAP_KEY = "imgHero"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val etName = bundle.getParcelable<Superhero>(SUPERHERO_KEY)!!
        val imgHero = bundle.getParcelable<Bitmap>(BITMAP_KEY)!!

        binding.imgHero.setImageBitmap(imgHero)
        binding.superhero = etName
    }
}
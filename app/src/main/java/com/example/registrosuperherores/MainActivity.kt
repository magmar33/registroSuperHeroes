package com.example.registrosuperherores

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import com.example.registrosuperherores.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var imgHero : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardar.setOnClickListener {
            val etName = binding.etName.text.toString()
            val etEgo = binding.etEgo.text.toString()
            val etBio = binding.etBio.text.toString()
            val rbPoder = binding.rbPoder.rating
            val hero = Superhero(etName, etEgo, etBio, rbPoder)
            openDetailActivity(hero)
        }

        imgHero = binding.imgHeroe
        imgHero.setOnClickListener {
            openCamera()
        }
    }

    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent,1000)
    }

    private fun openDetailActivity(superhero: Superhero){
        intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.SUPERHERO_KEY,superhero)
        intent.putExtra(DetailActivity.BITMAP_KEY,imgHero.drawable.toBitmap())
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == 1000) {
            val extras = data?.extras
            val heroImageBitmap = extras?.getParcelable<Bitmap>("data")
            imgHero.setImageBitmap(heroImageBitmap)

        }
    }
}
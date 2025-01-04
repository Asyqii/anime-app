package com.example.myanime

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.myanime.databinding.ActivityAboutPageBinding
import com.example.myanime.databinding.ActivityDetailBinding

class AboutPage : AppCompatActivity() {

    private lateinit var binding: ActivityAboutPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_page)
        binding = ActivityAboutPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val back: ImageView = binding.backAbout

        back.setOnClickListener {
            val moveIntent = Intent(this, MainActivity::class.java)

            startActivity(moveIntent)
        }


    }
}

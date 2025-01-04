package com.example.myanime

import android.app.Person
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myanime.databinding.ActivityDetailBinding
import com.example.myanime.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_HERO = "extra_hero"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val back = binding.back
        val share = binding.share

        back.setOnClickListener {
            val moveIntent = Intent(this@DetailActivity, MainActivity::class.java)
            startActivity(moveIntent)
        }

        share.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            val message: String = "https://github.com/AhmadSuyutiSyauqi"
            shareIntent.setType("text/plain");
            shareIntent.putExtra("Share this url", message);
            startActivity(Intent.createChooser(shareIntent, "Sharelink"))
        }

        val dataHero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Hero>(DetailActivity.EXTRA_HERO, Hero::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Hero>(DetailActivity.EXTRA_HERO)
        }

        dataHero?.let { hero ->
           binding.detailTitle.text = hero.name
            binding.detailDesc.text = hero.desc
            binding.itemEps.text = hero.eps
            binding.phoneImg.setImageResource(hero.photo)
        }


    }
}
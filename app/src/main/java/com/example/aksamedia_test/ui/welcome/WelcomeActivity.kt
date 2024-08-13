package com.example.aksamedia_test.ui.welcome

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.aksamedia_test.R
import com.example.aksamedia_test.databinding.ActivityWelcomeBinding
import com.example.aksamedia_test.ui.product.MainActivity
import com.example.aksamedia_test.ui.welcome.adapter.IndicatorAdapter

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {
        val indicator = binding.dotsIndicator
        val adapter = IndicatorAdapter(this)
        val viewPager = binding.welcomeViewPager
        viewPager.adapter = adapter
        indicator.attachTo(viewPager)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                changeTextPage(position)
            }
        })

        binding.btnNext.setOnClickListener {
            if (viewPager.currentItem < adapter.itemCount - 1) {
                viewPager.currentItem += 1
            } else {
                val options = ActivityOptionsCompat.makeCustomAnimation(
                    this,
                    R.anim.slide_in_right,
                    R.anim.slide_out_left
                )
                startActivity(Intent(this, MainActivity::class.java), options.toBundle())
                finish()
            }
        }
    }

    private fun changeTextPage(position: Int) {
        when(position) {
            0 ->  {
                binding.titleWelcome.text = getString(R.string.dummy_title)
                binding.descWelcome.text = getString(R.string.dummy_desc)
            }
            1 -> {
                binding.titleWelcome.text = getString(R.string.second_title)
                binding.descWelcome.text = getString(R.string.second_desc)
            }
            2 -> {
                binding.titleWelcome.text = getString(R.string.third_title)
                binding.descWelcome.text = getString(R.string.third_desc)
            }
        }
    }
}
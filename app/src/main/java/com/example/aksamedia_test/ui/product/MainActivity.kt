package com.example.aksamedia_test.ui.product

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aksamedia_test.R
import com.example.aksamedia_test.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var isTextExpanded = false

    private var bottomDialog: BottomSheetDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupListener()
    }

    private fun setupListener() {
        binding.apply {
            val clipBoardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            var clipData: ClipData

            toggle.setOnClickListener {
                if (isTextExpanded) {
                    descriptionProduct.maxLines = 6
                    txtToggle.text = ContextCompat.getString(this@MainActivity, R.string.implicit)
                    descriptionProduct.text = ContextCompat.getString(this@MainActivity, R.string.short_text)
                    isTextExpanded = false
                    icArrowDown.setImageResource(R.drawable.ic_arrow_down)
                } else {
                    descriptionProduct.maxLines = Int.MAX_VALUE
                    txtToggle.text = ContextCompat.getString(this@MainActivity, R.string.hide)
                    descriptionProduct.text = ContextCompat.getString(this@MainActivity, R.string.full_text)
                    icArrowDown.setImageResource(R.drawable.ic_arrow_up)
                    isTextExpanded = true
                }
            }
            icCopy.setOnClickListener {
                val descriptionProduct = descriptionProduct.text
                clipData = ClipData.newPlainText("text", descriptionProduct)
                clipBoardManager.setPrimaryClip(clipData)
                Toast.makeText(this@MainActivity, "Copied to Clipboard", Toast.LENGTH_SHORT).show()
            }
            btnAdd.setOnClickListener { Toast.makeText(this@MainActivity, "Added to Merchant", Toast.LENGTH_SHORT).show() }
            informationProduct.icShare.setOnClickListener {
                bottomDialog =  BottomSheetDialog(this@MainActivity).apply {
                    val view = layoutInflater.inflate(R.layout.bottom_sheet_share, null)
                    val btnClose = view.findViewById<ImageView>(R.id.ic_close)
                    btnClose.setOnClickListener { dismiss() }
                    setCancelable(false)
                    setContentView(view)
                    show()
                }
            }
            product1.btnShare.setOnClickListener {
                bottomDialog =  BottomSheetDialog(this@MainActivity).apply {
                    val view = layoutInflater.inflate(R.layout.bottom_sheet_share, null)
                    val btnClose = view.findViewById<ImageView>(R.id.ic_close)
                    btnClose.setOnClickListener { dismiss() }
                    setCancelable(false)
                    setContentView(view)
                    show()
                }
            }
            product2.btnShare.setOnClickListener {
                bottomDialog =  BottomSheetDialog(this@MainActivity).apply {
                    val view = layoutInflater.inflate(R.layout.bottom_sheet_share, null)
                    val btnClose = view.findViewById<ImageView>(R.id.ic_close)
                    btnClose.setOnClickListener { dismiss() }
                    setCancelable(false)
                    setContentView(view)
                    show()
                }
            }
        }
    }

    private fun setupView() {
        binding.apply {
            product1.newTag.visibility = View.GONE
            product2.newTag.visibility = View.GONE
        }
    }
}
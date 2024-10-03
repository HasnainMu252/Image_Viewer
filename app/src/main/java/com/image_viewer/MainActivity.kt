package com.image_viewer

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val buttonNext = findViewById<Button>(R.id.button)
        val buttonPrevious = findViewById<Button>(R.id.button2)
        val textView = findViewById<TextView>(R.id.textView)

        val ids: Array<Int> = arrayOf(
            R.drawable.a,
            R.drawable.ace,
            R.drawable.vcg,
            R.drawable.asda,
            R.drawable.asdasd,
            R.drawable.csdfg,
            R.drawable.asdas,
            R.drawable.xzc
            ,
            R.drawable.zxzcxc,
            R.drawable.zxcz

            ,
        )

        var counter = 0
        val totalCounter = ids.size
        var currentImage = counter + 1

        textView.text = "$currentImage/$totalCounter"
        imageView.setImageResource(ids[counter])

        // Next Button (Button1)

        fun updateUI() {
            imageView.setImageResource(ids[counter])
            textView.text = "${counter + 1}/$totalCounter"


            buttonPrevious.isEnabled = counter != 0


            buttonNext.isEnabled = counter != ids.size - 1
        }

        updateUI()


        buttonNext.setOnClickListener {
            if (counter < ids.size - 1) {
                counter++
                updateUI()
            }
        }

        // Previous Button (Button2)
        buttonPrevious.setOnClickListener {
            if (counter > 0) {
                counter--
                updateUI()
            }
        }

         ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

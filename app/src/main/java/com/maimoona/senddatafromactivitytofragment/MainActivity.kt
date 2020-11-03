package com.maimoona.senddatafromactivitytofragment

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private lateinit var redButton: Button
private lateinit var greenButton: Button
private lateinit var blueButton: Button
private lateinit var textData: TextView

class MainActivity : AppCompatActivity(), ColorFragment.Callbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        redButton = findViewById(R.id.red)
        greenButton = findViewById(R.id.green)
        blueButton = findViewById(R.id.blue)
        textData = findViewById(R.id.txt_text)

        sendColor("Choose Color")
        redButton.setOnClickListener {
            sendColor("red")
        }

        greenButton.setOnClickListener {
            sendColor("green")
        }

        blueButton.setOnClickListener {
            sendColor("blue")
        }


        val currentFragment = supportFragmentManager.findFragmentById(R.id.frameLayout_container2)
        if (currentFragment == null) {
            val fragment = SecondFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frameLayout_container2, fragment)
                .commit()
        }

    }

    fun sendColor(color: String) {
        supportFragmentManager.findFragmentById(R.id.frameLayout_container)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout_container, ColorFragment.newInstance(color)).commit()

    }

    override fun onAddName(name: String) {
        textData.setText(name)
        textData.setTextSize(45F)
        textData.setTextColor(Color.RED)
        supportFragmentManager.findFragmentById(R.id.frameLayout_container2)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout_container2, SecondFragment.newInstance(name))
            .commit()
    }
}
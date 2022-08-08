package com.tuwiq.vatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.tuwiq.vatapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binging : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binging = ActivityMainBinding.inflate(layoutInflater)
        val view = binging.root
        setContentView(view)

        binging.btnCalculateVat.setOnClickListener {
            calculateVat()
        }

    }

    private fun calculateVat() {
        TODO("Not yet implemented")


    }
}
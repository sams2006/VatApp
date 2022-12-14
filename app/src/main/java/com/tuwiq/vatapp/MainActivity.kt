package com.tuwiq.vatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.tuwiq.vatapp.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binging: ActivityMainBinding

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

        val getTextCost = binging.edTotalCost.text.toString()
        val cost = getTextCost.toDouble()

        var total = when (binging.rgVatOption.checkedRadioButtonId) {
            R.id.rb_vat_10 -> cost * 1.10
            R.id.rb_vat_15 -> cost * 1.15
            else -> cost * 1.20
        }


        val switchChecked = binging.switchRoundUp.isChecked

       if (switchChecked) {
           total = kotlin.math.ceil(total)
       }
        val totalFormatting = NumberFormat.getCurrencyInstance().format(total)
        binging.txtCostTotal.text = getString(R.string.total_format, totalFormatting)
    }
}
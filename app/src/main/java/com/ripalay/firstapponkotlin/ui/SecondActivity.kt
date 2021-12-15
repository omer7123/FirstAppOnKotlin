package com.ripalay.firstapponkotlin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ripalay.firstapponkotlin.R
import com.ripalay.firstapponkotlin.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainEdit.setText(intent.getStringExtra("txt"))
        binding.fabBtn.setOnClickListener {
            if (binding.mainEdit.text.toString() == "") {
                Toast.makeText(this, "Поле не может быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                var intent = Intent()
                intent.putExtra("fd", binding.mainEdit.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}
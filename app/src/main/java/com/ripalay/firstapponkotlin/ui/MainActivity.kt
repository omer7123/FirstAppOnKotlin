package com.ripalay.firstapponkotlin.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.ripalay.firstapponkotlin.R
import com.ripalay.firstapponkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var launcher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.mainEdit.setText(result.data?.getStringExtra("fd"))
                }
            }
        binding.fabBtn.setOnClickListener {
            if (binding.mainEdit.text.toString().trim() == "") {
                Toast.makeText(this, "Поле не может быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                val text: String = binding.mainEdit.text.toString()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("txt", text)
                launcher.launch(intent)
            }
        }
    }
}
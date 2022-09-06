package com.example.tp31

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp31.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    binding.btnAvancarTela2.setOnClickListener {

        val nome = binding.inputNome.text.toString()

        val intent = Intent(this,QuestoesActivity::class.java)
        intent.putExtra(NOME, nome)
        startActivity(intent)
    }

    }

    companion object {

        val NOME = "NOME"

    }

}
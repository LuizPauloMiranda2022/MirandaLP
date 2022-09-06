package com.example.tp31

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp31.databinding.ActivityMainBinding
import com.example.tp31.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding


    var nome = ""
    var resultado = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

       nome = intent.getStringExtra(MainActivity.NOME) ?: ""
       resultado = intent.getIntExtra(QuestoesActivity.RESULTADO,0)

        binding.nomeResultado.text = nome
        binding.textoResultado.text = resultado.toString()

    }

}
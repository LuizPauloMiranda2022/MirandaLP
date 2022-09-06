package com.example.tp31

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp31.databinding.ActivityMainBinding
import com.example.tp31.databinding.ActivityQuestoesBinding
import com.example.tp31.interfaces.OuvintesDeRespostas

class QuestoesActivity : AppCompatActivity(), OuvintesDeRespostas {

    private lateinit var binding: ActivityQuestoesBinding

    val listaRepostas = mutableListOf<String>()
    var nome = ""
    var pontos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestoesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        nome = intent.getStringExtra(MainActivity.NOME) ?: ""


    }

    override fun onAnswerSubmit(resposta: Int) {



        pontos+= resposta
        if (concluir){
            concluirQuestionario()
        }


    }

    fun concluirQuestionario() {






        val intentResposta = Intent(this, ResultadoActivity::class.java)
        intentResposta.putExtra(MainActivity.NOME, nome)
        intentResposta.putExtra(RESULTADO,pontos)

        startActivity(intentResposta)
    }

    companion object {
        val RESULTADO = "RESULTADO"
        var concluir = false

    }
}
package com.example.tp31

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tp31.databinding.FragmentQuestao8Binding
import com.example.tp31.databinding.FragmentQuestao9Binding
import com.example.tp31.interfaces.OuvintesDeRespostas

class Questao9Fragment : Fragment() {

    private var _binding: FragmentQuestao9Binding? = null

    private val binding get() = _binding!!

    private lateinit var ouvintesDeRespostas: OuvintesDeRespostas

    override fun onAttach(context: Context){
        if(context is OuvintesDeRespostas){

            ouvintesDeRespostas = context
        }



        super.onAttach(context)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestao9Binding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnConfirmaRespostaQ9.setOnClickListener{

            if(binding.radioGroupQ9.checkedRadioButtonId != -1){

                QuestoesActivity.concluir = true

                when(binding.radioGroupQ9.checkedRadioButtonId){
                    R.id.rb_q9_itema -> {ouvintesDeRespostas.onAnswerSubmit(0)}
                    R.id.rb_q9_itemb -> {ouvintesDeRespostas.onAnswerSubmit(1)}
                    R.id.rb_q9_itemc -> {ouvintesDeRespostas.onAnswerSubmit(2)}
                    R.id.rb_q9_itemd -> {ouvintesDeRespostas.onAnswerSubmit(4)}
                    R.id.rb_q9_iteme -> {ouvintesDeRespostas.onAnswerSubmit(5)}
                }

                // Navegar para o proximo Activity


            }

        }


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
package com.example.tp31

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.tp31.databinding.FragmentQuestao7Binding
import com.example.tp31.databinding.FragmentQuestao8Binding
import com.example.tp31.interfaces.OuvintesDeRespostas

class Questao8Fragment : Fragment() {

    private var _binding: FragmentQuestao8Binding? = null

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
        _binding = FragmentQuestao8Binding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnConfirmaRespostaQ8.setOnClickListener{

            if(binding.radioGroupQ8.checkedRadioButtonId != -1){

                when(binding.radioGroupQ8.checkedRadioButtonId){
                    R.id.rb_q8_itema -> {ouvintesDeRespostas.onAnswerSubmit(0)}
                    R.id.rb_q8_itemb -> {ouvintesDeRespostas.onAnswerSubmit(0)}
                    R.id.rb_q8_itemc -> {ouvintesDeRespostas.onAnswerSubmit(0)}
                    R.id.rb_q8_itemd -> {ouvintesDeRespostas.onAnswerSubmit(4)}

                }

                // Navegar para o proximo fragment
                view.findNavController().navigate(R.id.action_questao8Fragment_to_questao9Fragment)

            }

        }


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
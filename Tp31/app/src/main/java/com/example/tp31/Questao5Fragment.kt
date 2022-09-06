package com.example.tp31

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.tp31.databinding.FragmentQuestao4Binding
import com.example.tp31.databinding.FragmentQuestao5Binding
import com.example.tp31.interfaces.OuvintesDeRespostas

class Questao5Fragment : Fragment() {

    private var _binding: FragmentQuestao5Binding? = null

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
        _binding = FragmentQuestao5Binding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnConfirmaRespostaQ5.setOnClickListener{

            if(binding.radioGroupQ5.checkedRadioButtonId != -1){

                when(binding.radioGroupQ5.checkedRadioButtonId){
                    R.id.rb_q5_itema -> {ouvintesDeRespostas.onAnswerSubmit(0)}
                    R.id.rb_q5_itemb -> {ouvintesDeRespostas.onAnswerSubmit(2)}
                    R.id.rb_q5_itemc -> {ouvintesDeRespostas.onAnswerSubmit(4)}

                }

                // Navegar para o proximo fragment
                view.findNavController().navigate(R.id.action_questao5Fragment_to_questao6Fragment)

            }

        }


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
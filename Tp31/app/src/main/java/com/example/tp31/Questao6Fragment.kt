package com.example.tp31

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.tp31.databinding.FragmentQuestao5Binding
import com.example.tp31.databinding.FragmentQuestao6Binding
import com.example.tp31.interfaces.OuvintesDeRespostas

class Questao6Fragment : Fragment() {

    private var _binding: FragmentQuestao6Binding? = null

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
        _binding = FragmentQuestao6Binding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnConfirmaRespostaQ6.setOnClickListener{

            if(binding.radioGroupQ6.checkedRadioButtonId != -1){

                when(binding.radioGroupQ6.checkedRadioButtonId){
                    R.id.rb_q6_itema -> {ouvintesDeRespostas.onAnswerSubmit(0)}
                    R.id.rb_q6_itemb -> {ouvintesDeRespostas.onAnswerSubmit(0)}
                    R.id.rb_q6_itemc -> {ouvintesDeRespostas.onAnswerSubmit(3)}
                    R.id.rb_q6_itemd -> {ouvintesDeRespostas.onAnswerSubmit(4)}

                }

                // Navegar para o proximo fragment
                view.findNavController().navigate(R.id.action_questao6Fragment_to_questao7Fragment)

            }

        }


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
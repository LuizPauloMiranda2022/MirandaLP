package com.example.tp31

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.tp31.databinding.FragmentQuestao1Binding
import com.example.tp31.databinding.FragmentQuestao2Binding
import com.example.tp31.interfaces.OuvintesDeRespostas


class Questao2Fragment : Fragment() {
    private var _binding: FragmentQuestao2Binding? = null

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
        _binding = FragmentQuestao2Binding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnConfirmaRespostaQ2.setOnClickListener{

            if(binding.radioGroupQ2.checkedRadioButtonId != -1){

                when(binding.radioGroupQ2.checkedRadioButtonId){
                    R.id.rb_q2_itema -> {ouvintesDeRespostas.onAnswerSubmit(0)}
                    R.id.rb_q2_itemb -> {ouvintesDeRespostas.onAnswerSubmit(2)}
                    R.id.rb_q2_itemc -> {ouvintesDeRespostas.onAnswerSubmit(4)}
                    R.id.rb_q2_itemd -> {ouvintesDeRespostas.onAnswerSubmit(5)}
                }

                // Navegar para o proximo fragment
                view.findNavController().navigate(R.id.action_questao2Fragment_to_questao3Fragment)

            }
        }




        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
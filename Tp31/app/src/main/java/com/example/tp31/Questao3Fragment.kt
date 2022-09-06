package com.example.tp31

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.tp31.databinding.FragmentQuestao2Binding
import com.example.tp31.databinding.FragmentQuestao3Binding
import com.example.tp31.interfaces.OuvintesDeRespostas

class Questao3Fragment : Fragment() {

    private var _binding: FragmentQuestao3Binding? = null

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
        _binding = FragmentQuestao3Binding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnConfirmaRespostaQ3.setOnClickListener{

            if(binding.radioGroupQ3.checkedRadioButtonId != -1){

                when(binding.radioGroupQ3.checkedRadioButtonId){
                    R.id.rb_q3_itema -> {ouvintesDeRespostas.onAnswerSubmit(0)}
                    R.id.rb_q3_itemb -> {ouvintesDeRespostas.onAnswerSubmit(1)}
                    R.id.rb_q3_itemc -> {ouvintesDeRespostas.onAnswerSubmit(2)}
                    R.id.rb_q3_itemd -> {ouvintesDeRespostas.onAnswerSubmit(4)}
                }

                // Navegar para o proximo fragment
                view.findNavController().navigate(R.id.action_questao3Fragment_to_questao4Fragment)

            }
        }




        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
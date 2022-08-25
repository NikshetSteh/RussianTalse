package com.supmegcompany.russian_tales.fragments.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.supmegcompany.russian_tales.R
import com.supmegcompany.russian_tales.data.QuizResult
import com.supmegcompany.russian_tales.databinding.FragmentQuizRezultViewBinding

class QuizResultView : Fragment() {

    private lateinit var binding: FragmentQuizRezultViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizRezultViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        var resultResult = 0
        if(result.rightAnswer == 0){
            binding.result.text = "0%"
        }else {
            resultResult = (result.rightAnswer.toFloat() / result.questionCount.toFloat() * 100.0).toInt()
            binding.result.text = "${resultResult}%"
        }
        when {
            resultResult == 100 -> {
                binding.resultText.text = resources.getString(R.string.result_100)
            }
            resultResult > 85 -> {
                binding.resultText.text = resources.getString(R.string.result_85)
            }
            resultResult > 75 -> {
                binding.resultText.text = resources.getString(R.string.result_75)
            }
            else -> {
                binding.resultText.text = resources.getString(R.string.result_0)
            }
        }
        binding.resultCount.text = "${result.rightAnswer}/${result.questionCount}"
    }

    companion object{
        lateinit var result: QuizResult
    }

}
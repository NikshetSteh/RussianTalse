package com.supmegcompany.russian_tales.fragments.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.supmegcompany.russian_tales.MainActivity
import com.supmegcompany.russian_tales.R
import com.supmegcompany.russian_tales.data.Quiz
import com.supmegcompany.russian_tales.data.QuizResult
import com.supmegcompany.russian_tales.databinding.FragmentQuizViewBinding

class QuizView : Fragment() {

    private lateinit var binding: FragmentQuizViewBinding

    private var nowQuestion: Int = 0
    private var nowOptions: Int = -1
    private var ball: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun next(view: View){
        try {
            nowQuestion++
            if (binding.root.findViewById<RadioButton>(binding.buttons.checkedRadioButtonId).text.toString() == nowQuiz.answer[nowQuestion - 1]) {
                ball++
            }
            if (nowQuestion >= nowQuiz.question.size) {
                QuizResultView.result = QuizResult(nowQuiz.question.size, ball)
                nowQuestion = 0
                nowOptions = 0
                MainActivity.mainActivity.fragmentTransactionById(R.layout.fragment_quiz_rezult_view)
                return
            }
            view(nowQuestion)
        }catch (e:Exception){
            nowQuestion--
        }
    }

    private fun view(now: Int){
        binding.options3.isVisible = false
        binding.options4.isVisible = false

        binding.options1.text = nowQuiz.options[++nowOptions]
        binding.options2.text = nowQuiz.options[++nowOptions]
        if (nowQuiz.optionsCount[nowQuestion] > 2){
            binding.options3.isVisible = true
            binding.options3.text = nowQuiz.options[++nowOptions]
        }
        if (nowQuiz.optionsCount[nowQuestion] > 3){
            binding.options4.isVisible = true
            binding.options4.text = nowQuiz.options[++nowOptions]
        }

        binding.question.text = nowQuiz.question[now]
        binding.questionNumber.text = "$now/${nowQuiz.question.size}"
    }

    override fun onStart() {
        super.onStart()
        view(nowQuestion)
        binding.push.setOnClickListener(::next)
    }

    companion object{
        lateinit var nowQuiz: Quiz
    }
}
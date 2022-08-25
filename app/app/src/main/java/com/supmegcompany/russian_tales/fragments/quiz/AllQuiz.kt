package com.supmegcompany.russian_tales.fragments.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.supmegcompany.russian_tales.MainActivity
import com.supmegcompany.russian_tales.R
import com.supmegcompany.russian_tales.data.Quiz
import com.supmegcompany.russian_tales.data.ResourceManager
import com.supmegcompany.russian_tales.databinding.FragmentAllQuizBinding
import com.supmegcompany.russian_tales.databinding.QuizItemBinding

class AllQuiz : Fragment(){

    private lateinit var bindings: FragmentAllQuizBinding
    private var adapter = AllQuizAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindings = com.supmegcompany.russian_tales.databinding.FragmentAllQuizBinding.inflate(inflater, container, false)
        return bindings.root
    }

    override fun onStart() {
        super.onStart()
        bindings.apply {
            quizs.layoutManager = LinearLayoutManager(context)
            quizs.adapter = adapter
        }

        adapter.removeAll()

        for(i in 0 until ResourceManager.getQuizListSize()){
            adapter.addQuiz(ResourceManager.getQuiz(i))
        }

    }
}

class AllQuizAdapter: RecyclerView.Adapter<AllQuizHolder>(){
    private var quizList = ArrayList<Quiz>()

    override fun getItemCount(): Int {
        return quizList.size
    }

    private fun onClickToItem(view: View){
        QuizView.nowQuiz = ResourceManager.getQuiz(view.findViewById<TextView>(R.id.quiz_item_id).text.toString().toInt())
        MainActivity.mainActivity.fragmentTransactionById(R.layout.fragment_quiz_view)
    }

    override fun onBindViewHolder(holder: AllQuizHolder, position: Int) {
        holder.bind(quizList[position], ::onClickToItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllQuizHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quiz_item, parent, false)
        return AllQuizHolder(view)
    }

    fun addQuiz(quiz: Quiz){
        quizList.add(quiz)
        notifyDataSetChanged()
    }

    fun removeAll(){
        val iterator = quizList.iterator()
        while(iterator.hasNext()){
            val item = iterator.next()
            iterator.remove()
        }
    }

}

class AllQuizHolder(item: View): RecyclerView.ViewHolder(item){
    private val binding = QuizItemBinding.bind(item)
    fun bind(quiz: Quiz, onClick: (view: View) -> Unit)  = with(binding){
        quizItemName.text = quiz.name
        hard.text = quiz.hard.toString()
        questionCount.text = quiz.question.size.toString()
        quizItemId.text = quiz.id.toString()
        quizItemContainer.setOnClickListener(onClick)
    }
}

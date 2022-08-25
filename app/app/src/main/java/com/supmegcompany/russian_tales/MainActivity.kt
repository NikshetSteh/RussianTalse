package com.supmegcompany.russian_tales

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.supmegcompany.russian_tales.data.ResourceManager
import com.supmegcompany.russian_tales.fragments.quiz.AllQuiz
import com.supmegcompany.russian_tales.fragments.quiz.QuizResultView
import com.supmegcompany.russian_tales.fragments.quiz.QuizView
import com.supmegcompany.russian_tales.fragments.tales.*

class MainActivity : AppCompatActivity() {

    private val fragMgr = supportFragmentManager

    //fragments
    private val allTalesFragment = AllTales()
    private val allQuizFragment = AllQuiz()
    private val talesViewFragment = TalesView()
    private val talesFindFragment = FindTales()
    private val quizViewFragment = QuizView()
    private val quizResultViewFragment = QuizResultView()
    private val allTalesEditorFragment = AllEditTales()
    private val talesEditorFragment = TalesEditor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivity = this

        ResourceManager.start(applicationContext)
    }

    fun fragmentTransaction(view: View) {
        fragmentTransactionById(view.id)
    }

    fun fragmentTransactionById(id: Int) {
        val fragmentTransaction = fragMgr.beginTransaction()
        when (id) {
            R.id.all_tales_b -> fragmentTransaction.replace(R.id.container, allTalesFragment)
            R.id.quiz_b -> fragmentTransaction.replace(R.id.container, allQuizFragment)
            R.layout.fragment_tales_view -> fragmentTransaction.replace(R.id.container, talesViewFragment)
            R.layout.fragment_find_tales -> fragmentTransaction.replace(R.id.container, talesFindFragment)
            R.layout.fragment_quiz_view -> fragmentTransaction.replace(R.id.container, quizViewFragment)
            R.layout.fragment_quiz_rezult_view -> fragmentTransaction.replace(R.id.container, quizResultViewFragment)
            R.layout.fragment_all_edit_tales -> fragmentTransaction.replace(R.id.container, allTalesEditorFragment)
            R.id.creat_tales_b -> fragmentTransaction.replace(R.id.container, allTalesEditorFragment)
            R.layout.fragment_tales_editor -> fragmentTransaction.replace(R.id.container, talesEditorFragment)
            else -> {
            }
        }
        fragmentTransaction.commit()
    }

//    override fun onStart() {
//        super.onStart()
//        getSharedPreferences("", AppCompatActivity.MODE_PRIVATE).edit().putString("EDIT_TALES", "").apply()
//    }

    companion object{
        lateinit var mainActivity: MainActivity
    }
}
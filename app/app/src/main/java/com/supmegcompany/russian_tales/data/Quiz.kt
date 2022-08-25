package com.supmegcompany.russian_tales.data

class Quiz(val question: ArrayList<String>,val  answer: ArrayList<String>,val  options: ArrayList<String>,val  optionsCount: ArrayList<Int>,val  hard: Int,val  name: String, val id: Int) {}

class QuizResult(val questionCount: Int, val rightAnswer: Int)

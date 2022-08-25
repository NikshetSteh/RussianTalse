package com.supmegcompany.russian_tales.data

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.supmegcompany.russian_tales.R
import java.io.*


class ResourceManager {

    companion object{
        private const val EDIT_TALES = "EDIT_TALES"
        private const val NEXT_ID = "NEXT_ID"

        private var talesList = ArrayList<Tales>()
        private var quizList = ArrayList<Quiz>()

        fun getTales(id: Int): Tales {
            return talesList[id]
        }

        fun start(context: Context){
            val iterator = talesList.iterator()
            while(iterator.hasNext()){
                iterator.next()
                iterator.remove()
            }

            val iterator2 = quizList.iterator()
            while(iterator2.hasNext()){
                iterator2.next()
                iterator2.remove()
            }


            lateinit var tale: Tales

            lateinit var quiz1: Quiz

            context.apply {
                tale = Tales(
                    0,
                    resources.getString(R.string.tale1_name),
                    resources.getString(R.string.tale1_text),
                    resources.getString(R.string.tale1_author),
                    resources.getString(R.string.tale1_plot),
                    resources.getString(R.string.tale1_characters),
                    resources.getString(R.string.tale1_history_creation),
                    R.drawable.colobok
                )

                talesList.add(tale)


                tale = Tales(
                    1,
                    resources.getString(R.string.tale2_name),
                    resources.getString(R.string.tale2_text),
                    resources.getString(R.string.tale2_author),
                    resources.getString(R.string.tale2_plot),
                    resources.getString(R.string.tale2_characters),
                    resources.getString(R.string.tale2_history_creation),
                    R.drawable.gold_key
                )

                talesList.add(tale)

                tale = Tales(
                    2,
                    resources.getString(R.string.tale3_name),
                    resources.getString(R.string.tale3_text),
                    resources.getString(R.string.tale3_author),
                    resources.getString(R.string.tale3_plot),
                    resources.getString(R.string.tale3_characters),
                    resources.getString(R.string.tale3_history_creation),
                    R.drawable.fly_ship
                )

                talesList.add(tale)

                tale = Tales(
                    3,
                    resources.getString(R.string.tale4_name),
                    resources.getString(R.string.tale4_text),
                    resources.getString(R.string.tale4_author),
                    resources.getString(R.string.tale4_plot),
                    resources.getString(R.string.tale4_characters),
                    resources.getString(R.string.tale4_history_creation),
                    R.drawable.morozka
                )

                talesList.add(tale)

                tale = Tales(
                    4,
                    resources.getString(R.string.tale5_name),
                    resources.getString(R.string.tale5_text),
                    resources.getString(R.string.tale5_author),
                    resources.getString(R.string.tale5_plot),
                    resources.getString(R.string.tale5_characters),
                    resources.getString(R.string.tale5_history_creation),
                    R.drawable.repa
                )

                talesList.add(tale)

                tale = Tales(
                    5,
                    resources.getString(R.string.tale6_name),
                    resources.getString(R.string.tale6_text),
                    resources.getString(R.string.tale6_author),
                    resources.getString(R.string.tale6_plot),
                    resources.getString(R.string.tale6_characters),
                    resources.getString(R.string.tale6_history_creation),
                    R.drawable.tale_of_barmaley
                )

                talesList.add(tale)

                tale = Tales(
                    6,
                    resources.getString(R.string.tale7_name),
                    resources.getString(R.string.tale7_text),
                    resources.getString(R.string.tale7_author),
                    resources.getString(R.string.tale7_plot),
                    resources.getString(R.string.tale7_characters),
                    resources.getString(R.string.tale7_history_creation),
                    R.drawable.terem
                )

                talesList.add(tale)

                var question = ArrayList<String>()

                question.add(resources.getString(R.string.quiz1_questions1))
                question.add(resources.getString(R.string.quiz1_questions2))
                question.add(resources.getString(R.string.quiz1_questions3))
                question.add(resources.getString(R.string.quiz1_questions4))
                question.add(resources.getString(R.string.quiz1_questions5))

                var answer = ArrayList<String>()

                answer.add(resources.getString(R.string.quiz1_right1))
                answer.add(resources.getString(R.string.quiz1_right2))
                answer.add(resources.getString(R.string.quiz1_right3))
                answer.add(resources.getString(R.string.quiz1_right4))
                answer.add(resources.getString(R.string.quiz1_right5))

                var options = ArrayList<String>()

                options.add(resources.getString(R.string.quiz1_options1_1))
                options.add(resources.getString(R.string.quiz1_options1_2))
                options.add(resources.getString(R.string.quiz1_options1_3))

                options.add(resources.getString(R.string.quiz1_options2_1))
                options.add(resources.getString(R.string.quiz1_options2_2))
                options.add(resources.getString(R.string.quiz1_options2_3))

                options.add(resources.getString(R.string.quiz1_options3_1))
                options.add(resources.getString(R.string.quiz1_options3_2))
                options.add(resources.getString(R.string.quiz1_options3_3))

                options.add(resources.getString(R.string.quiz1_options4_1))
                options.add(resources.getString(R.string.quiz1_options4_2))
                options.add(resources.getString(R.string.quiz1_options4_3))

                options.add(resources.getString(R.string.quiz1_options5_1))
                options.add(resources.getString(R.string.quiz1_options5_2))
                options.add(resources.getString(R.string.quiz1_options5_3))

                var optionsCount = ArrayList<Int>()

                for (i in resources.getIntArray(R.array.quiz1_options_count)) {
                    optionsCount.add(i)
                }

                quiz1 = Quiz(
                    question,
                    answer,
                    options,
                    optionsCount,
                    resources.getInteger(R.integer.quiz1_hard),
                    resources.getString(R.string.quiz1_name),
                    0
                )

                quizList.add(quiz1)

                question = ArrayList()

                question.add(resources.getString(R.string.quiz2_questions1))
                question.add(resources.getString(R.string.quiz2_questions2))
                question.add(resources.getString(R.string.quiz2_questions3))
                question.add(resources.getString(R.string.quiz2_questions4))
                question.add(resources.getString(R.string.quiz2_questions5))

                answer = ArrayList()

                answer.add(resources.getString(R.string.quiz2_right1))
                answer.add(resources.getString(R.string.quiz2_right2))
                answer.add(resources.getString(R.string.quiz2_right3))
                answer.add(resources.getString(R.string.quiz2_right4))
                answer.add(resources.getString(R.string.quiz2_right5))

                options = ArrayList()

                options.add(resources.getString(R.string.quiz2_options1_1))
                options.add(resources.getString(R.string.quiz2_options1_2))
                options.add(resources.getString(R.string.quiz2_options1_3))

                options.add(resources.getString(R.string.quiz2_options2_1))
                options.add(resources.getString(R.string.quiz2_options2_2))
                options.add(resources.getString(R.string.quiz2_options2_3))

                options.add(resources.getString(R.string.quiz2_options3_1))
                options.add(resources.getString(R.string.quiz2_options3_2))
                options.add(resources.getString(R.string.quiz2_options3_3))

                options.add(resources.getString(R.string.quiz2_options4_1))
                options.add(resources.getString(R.string.quiz2_options4_2))
                options.add(resources.getString(R.string.quiz2_options4_3))

                options.add(resources.getString(R.string.quiz2_options5_1))
                options.add(resources.getString(R.string.quiz2_options5_2))
                options.add(resources.getString(R.string.quiz2_options5_3))

                optionsCount = ArrayList()

                for (i in resources.getIntArray(R.array.quiz2_options_count)) {
                    optionsCount.add(i)
                }

                quiz1 = Quiz(
                    question,
                    answer,
                    options,
                    optionsCount,
                    resources.getInteger(R.integer.quiz2_hard),
                    resources.getString(R.string.quiz2_name),
                    1
                )

                quizList.add(quiz1)

                question = ArrayList()

                question.add(resources.getString(R.string.quiz3_questions1))
                question.add(resources.getString(R.string.quiz3_questions2))
                question.add(resources.getString(R.string.quiz3_questions3))
                question.add(resources.getString(R.string.quiz3_questions4))

                answer = ArrayList()

                answer.add(resources.getString(R.string.quiz3_right1))
                answer.add(resources.getString(R.string.quiz3_right2))
                answer.add(resources.getString(R.string.quiz3_right3))
                answer.add(resources.getString(R.string.quiz3_right4))

                options = ArrayList()

                options.add(resources.getString(R.string.quiz3_options1_1))
                options.add(resources.getString(R.string.quiz3_options1_2))
                options.add(resources.getString(R.string.quiz3_options1_3))

                options.add(resources.getString(R.string.quiz3_options2_1))
                options.add(resources.getString(R.string.quiz3_options2_2))
                options.add(resources.getString(R.string.quiz3_options2_3))

                options.add(resources.getString(R.string.quiz3_options3_1))
                options.add(resources.getString(R.string.quiz3_options3_2))
                options.add(resources.getString(R.string.quiz3_options3_3))

                options.add(resources.getString(R.string.quiz3_options4_1))
                options.add(resources.getString(R.string.quiz3_options4_2))
                options.add(resources.getString(R.string.quiz3_options4_3))

                optionsCount = ArrayList()

                for (i in resources.getIntArray(R.array.quiz3_options_count)) {
                    optionsCount.add(i)
                }

                quiz1 = Quiz(
                    question,
                    answer,
                    options,
                    optionsCount,
                    resources.getInteger(R.integer.quiz3_hard),
                    resources.getString(R.string.quiz3_name),
                    2
                )

                quizList.add(quiz1)

                question = ArrayList()

                question.add(resources.getString(R.string.quiz4_questions1))
                question.add(resources.getString(R.string.quiz4_questions2))
                question.add(resources.getString(R.string.quiz4_questions3))
                question.add(resources.getString(R.string.quiz4_questions4))
                question.add(resources.getString(R.string.quiz4_questions5))

                answer = ArrayList()

                answer.add(resources.getString(R.string.quiz4_right1))
                answer.add(resources.getString(R.string.quiz4_right2))
                answer.add(resources.getString(R.string.quiz4_right3))
                answer.add(resources.getString(R.string.quiz4_right4))
                answer.add(resources.getString(R.string.quiz4_right5))

                options = ArrayList()

                options.add(resources.getString(R.string.quiz4_options1_1))
                options.add(resources.getString(R.string.quiz4_options1_2))
                options.add(resources.getString(R.string.quiz4_options1_3))
                options.add(resources.getString(R.string.quiz4_options1_4))

                options.add(resources.getString(R.string.quiz4_options2_1))
                options.add(resources.getString(R.string.quiz4_options2_2))
                options.add(resources.getString(R.string.quiz4_options2_3))
                options.add(resources.getString(R.string.quiz4_options2_4))

                options.add(resources.getString(R.string.quiz4_options3_1))
                options.add(resources.getString(R.string.quiz4_options3_2))
                options.add(resources.getString(R.string.quiz4_options3_3))
                options.add(resources.getString(R.string.quiz4_options3_4))

                options.add(resources.getString(R.string.quiz4_options4_1))
                options.add(resources.getString(R.string.quiz4_options4_2))
                options.add(resources.getString(R.string.quiz4_options4_3))
                options.add(resources.getString(R.string.quiz4_options4_4))

                options.add(resources.getString(R.string.quiz4_options5_1))
                options.add(resources.getString(R.string.quiz4_options5_2))
                options.add(resources.getString(R.string.quiz4_options5_3))
                options.add(resources.getString(R.string.quiz4_options5_4))

                optionsCount = ArrayList()

                for (i in resources.getIntArray(R.array.quiz4_options_count)) {
                    optionsCount.add(i)
                }

                quiz1 = Quiz(
                    question,
                    answer,
                    options,
                    optionsCount,
                    resources.getInteger(R.integer.quiz4_hard),
                    resources.getString(R.string.quiz4_name),
                    3
                )

                quizList.add(quiz1)

                question = ArrayList()

                question.add(resources.getString(R.string.quiz5_questions1))
                question.add(resources.getString(R.string.quiz5_questions2))
                question.add(resources.getString(R.string.quiz5_questions3))
                question.add(resources.getString(R.string.quiz5_questions4))

                answer = ArrayList()

                answer.add(resources.getString(R.string.quiz5_right1))
                answer.add(resources.getString(R.string.quiz5_right2))
                answer.add(resources.getString(R.string.quiz5_right3))
                answer.add(resources.getString(R.string.quiz5_right4))

                options = ArrayList()

                options.add(resources.getString(R.string.quiz5_options1_1))
                options.add(resources.getString(R.string.quiz5_options1_2))
                options.add(resources.getString(R.string.quiz5_options1_3))
                options.add(resources.getString(R.string.quiz5_options1_4))

                options.add(resources.getString(R.string.quiz5_options2_1))
                options.add(resources.getString(R.string.quiz5_options2_2))
                options.add(resources.getString(R.string.quiz5_options2_3))
                options.add(resources.getString(R.string.quiz5_options2_4))

                options.add(resources.getString(R.string.quiz5_options3_1))
                options.add(resources.getString(R.string.quiz5_options3_2))
                options.add(resources.getString(R.string.quiz5_options3_3))
                options.add(resources.getString(R.string.quiz5_options3_4))

                options.add(resources.getString(R.string.quiz5_options4_1))
                options.add(resources.getString(R.string.quiz5_options4_2))
                options.add(resources.getString(R.string.quiz5_options4_3))
                options.add(resources.getString(R.string.quiz5_options4_4))

                optionsCount = ArrayList()

                for (i in resources.getIntArray(R.array.quiz5_options_count)) {
                    optionsCount.add(i)
                }

                quiz1 = Quiz(
                    question,
                    answer,
                    options,
                    optionsCount,
                    resources.getInteger(R.integer.quiz5_hard),
                    resources.getString(R.string.quiz5_name),
                    4
                )

                quizList.add(quiz1)
            }
        }

        fun getTalesListSize(): Int{
            return talesList.size
        }

        fun getQuizListSize(): Int{
            return quizList.size
        }

        fun getQuiz(id: Int): Quiz {
            return quizList[id]
        }

        fun getEditTales(context: Context): ArrayList<Int>{
            val editTalesList = ArrayList<Int>()
            var dop = ""
            val tales = context.getSharedPreferences("", AppCompatActivity.MODE_PRIVATE).getString(
                EDIT_TALES, "")
            if (tales != null) {
                for (i in tales){
                    if(i == ' '){
                        editTalesList.add(dop.toInt())
                    }else{
                        dop += i
                    }
                }
            }
            return editTalesList
        }

        private fun readFile(context: Context, fileName: String): List<String> {
            val file = BufferedReader(InputStreamReader(context.openFileInput(fileName)))
            val i = file.readLines()
            file.close()
            return i

        }
        private fun writeFile(context: Context, fileName: String, tales: Tales){
            val file = BufferedWriter(OutputStreamWriter(context.openFileOutput(fileName, Context.MODE_APPEND)))
            file.write(tales.name)
            file.write("\n" +
                    "&&&&\n")
            file.write(tales.text)
            file.write("\n" +
                    "&&&&\n")
            file.write(tales.author)
            file.write("\n" +
                    "&&&&\n")
            file.write(tales.plot)
            file.write("\n" +
                    "&&&&\n")
            file.write(tales.characters)
            file.write("\n" +
                    "&&&&\n")
            file.write(tales.historyCreation)
            file.write("\n" +
                    "&&&&\n")
            file.close()

        }

        fun getEditTales(context: Context, id: Int): Tales {
            val text = readFile(context, id.toString())

            val data = ArrayList<String>()
            var dop = ""

            for(i in text){
                if(i == "&&&&"){
                    data.add(dop)
                    dop = ""
                }else{
                    dop += "$i\n "
                }
            }
            return Tales(
                id,
                data[0],
                data[1],
                data[2],
                data[3],
                data[4],
                data[5],
                0
            )
        }

        fun addEditTales(context: Context, tales: Tales): Int{
            val id = context.getSharedPreferences("", AppCompatActivity.MODE_PRIVATE).getInt(NEXT_ID, 0)
            writeFile(context, id.toString(), tales)
            context.getSharedPreferences("", AppCompatActivity.MODE_PRIVATE).edit().putString(
                EDIT_TALES ,context.getSharedPreferences("", AppCompatActivity.MODE_PRIVATE).getString(
                    EDIT_TALES, "") + "$id ").apply()
            context.getSharedPreferences("", AppCompatActivity.MODE_PRIVATE).edit().putInt(NEXT_ID ,id + 1).apply()
            return 0
        }

        fun removeTales(context: Context ,id: String){
            context.getSharedPreferences("", AppCompatActivity.MODE_PRIVATE).edit().putString(
                EDIT_TALES,
                context.getSharedPreferences("", AppCompatActivity.MODE_PRIVATE).getString(
                    EDIT_TALES, "")?.replace("$id ", "")
            ).apply()

            val filePath =
                "${context.filesDir.path}/$id"

            val file = File(filePath)
            if (file.exists()) {
                file.delete()
            }
        }
    }
}
package com.example.todo_list

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Login : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn = findViewById<Button>(R.id.logButton)
        val username =findViewById<EditText>(R.id.nameInput)

        val task = findViewById<TextView>(R.id.taskText)
        val res = findViewById<TextView>(R.id.logResult)

        var i = 0

        var user = ""
        var kolvo = 0
        val zadachi = arrayListOf<String>()


        btn.setOnClickListener {



            if (username.text.toString()!= ""){
                if (i == 0){

                    user = username.text.toString()

                    username.setText("")
                    task.setText("Сколько задач вы хотите задать?")


                    i++


                }
                else if(i == 1){



                    kolvo =  username.toString().toInt()

                    username.setText("")
                    task.setText("Вводите текст задачи и нажимайте кнопку?")

                    i++


                }


                else if (i == 2){





                    for(j in 1..kolvo){
                        zadachi.add(username.toString())

                    }

                    println(user)
                    println(kolvo)
                    println(zadachi)


                    val dbHelper = db(this)
                    val db = dbHelper.writableDatabase
                    db.execSQL("INSERT INTO Events (Name, Kolvo, Zadachi) VALUES (user, kolvo, zadachi)")



                }

                res.setTextColor(getColor(R.color.green))
                res.text = "Готово"

            }
            else{
                res.setTextColor(getColor(R.color.red))
                res.text = "Введите данные"
            }


        }





    }
}
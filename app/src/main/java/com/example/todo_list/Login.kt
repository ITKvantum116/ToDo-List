package com.example.todo_list

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import java.io.IOException

class Login : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "Range")
    override fun onCreate(savedInstanceState: Bundle?) {


        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->



        }



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn = findViewById<Button>(R.id.logButton)
        val username =findViewById<EditText>(R.id.nameInput)

        val task = findViewById<TextView>(R.id.taskText)
        val res = findViewById<TextView>(R.id.logResult)

        var i = 0
        var x = 0

        var user = ""
        var kolvo = 0
        val zadachi = arrayListOf<String>()


        val dbHelper = db(this)
        val db = dbHelper.writableDatabase


        btn.setOnClickListener {



            if (username.toString() != ""){
                if (i == 0){






                    user = username.text.toString()


                    try {
                        val u = db.rawQuery("SELECT Kolvo FROM users WHERE Name = '$user'", null)
                        u.moveToFirst()
                        var n = u.getString(u.getColumnIndex("Kolvo"))

                        println("tuta")

                        val nxt = Intent(this, MainActivity::class.java)
                        nxt.putExtra("bez", user.toString())

                        launcher.launch(nxt)







                    }
                    catch(e: Exception) {
                        username.setText("")
                        task.setText("Сколько задач вы хотите задать?")


                        i++
                    }








                }
                else if(i == 1){



                    kolvo =  username.text.toString().toInt()
                    x =  username.text.toString().toInt()

                    username.setText("")
                    task.setText("Вводите текст задачи и нажимайте кнопку?")

                    i++


                }


                else if (i == 2){

                    if (x > 0){
                        zadachi.add(username.text.toString())
                        username.setText("")
                        x --

                        if (x == 0){

                            db.execSQL("INSERT INTO users (Name, Kolvo, Zadachi) VALUES ('" + user + "', " + kolvo + ", '" + zadachi.toString() +  "')")



                            val nxt = Intent(this, MainActivity::class.java)
                            nxt.putExtra("bez", user.toString())

                            launcher.launch(nxt)



                            //startActivity(openIntent)


                       /*     val openIntent = Intent(this, MainActivity::class.java)
                            openIntent.putExtra("someData", user.toString())
                            startActivity(openIntent)
*/
                        }

                    }

                    /*for(j in 1..kolvo){
                        println(zadachi)
                        zadachi.add(username.text.toString())

                    }*/


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
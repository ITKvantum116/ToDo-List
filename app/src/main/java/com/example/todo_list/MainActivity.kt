package com.example.todo_list

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {





        //n.setText("Здравствуйте, " + user)




        // Заполняем основное окно
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val n = findViewById<TextView>(R.id.nameLabel)
        val greatText = intent.getStringExtra("bez")
        if(greatText != null){

            n.text = greatText
        }




        val helper = db(this)
        val db = helper.writableDatabase
        val k = db.rawQuery("SELECT Kolvo FROM users WHERE Name = '" + greatText + "'", null)
        val s1 = db.rawQuery("SELECT Zadachi FROM users WHERE Name = '" + greatText + "'", null)

        k.moveToFirst()
        var kol = k.getString(k.getColumnIndex("Kolvo"))

        s1.moveToFirst()
        var za = s1.getString(s1.getColumnIndex("Zadachi"))


        za = za.substring(1, za.length - 1)
        val list = za.split(", ")


        // Инициализируем список под названием events типа RecycleView, заполняя его с помощью адаптера EventsAdapter
        val events = findViewById<View>(R.id.mainList) as RecyclerView
        val eventsList = ArrayList<Event>()
        for (i in 1..kol.toString().toInt()) {
            var a = list[i-1]
            eventsList.add(Event("$a"))
        }
        val adapter = EventsAdapter(eventsList)
        events.adapter = adapter
        events.layoutManager = LinearLayoutManager(this)




    }
}
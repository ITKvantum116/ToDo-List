package com.example.todo_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Заполняем основное окно
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализируем список под названием events типа RecycleView, заполняя его с помощью адаптера EventsAdapter
        val events = findViewById<View>(R.id.mainList) as RecyclerView
        val eventsList = ArrayList<Event>()
        for (i in 1..5) {
            eventsList.add(Event("Событие №$i"))
        }
        val adapter = EventsAdapter(eventsList)
        events.adapter = adapter
        events.layoutManager = LinearLayoutManager(this)


        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {


            val openIntent = Intent(this, Login::class.java)
            openIntent.putExtra("someData", "Дополнительные данные (необязательно)")
            startActivity(openIntent)

        }
    }
}
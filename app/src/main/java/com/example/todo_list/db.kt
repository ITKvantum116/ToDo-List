package com.example.todo_list

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class db (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION)   {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE users (ID INTEGER PRIMARY KEY, Name TEXT, Kolvo INT, Zadachi TEXT)")
        db.execSQL("CREATE TABLE TaskCheck (ID INTEGER PRIMARY KEY, Name TEXT, Num INT, Task TEXT, Ex TEXT)")
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS users")
        //onCreate(db)
        db.execSQL("DROP TABLE IF EXISTS TaskCheck")
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
    companion object {
        const val DATABASE_VERSION = 2
        const val DATABASE_NAME = "Events.db"
    }
}
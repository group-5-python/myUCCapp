package com.example.myuccapp

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "uccCourses.db"
        private const val DATABASE_VERSION = 1
        private const val Tbl_NAME = "uccCourses"
        private const val col_ID = "Id"
        private const val colTitle = "title"
        private const val colCode = "code"
        private const val colCredit = "credit"
        private const val colPrerequisites = "prerequisites"
        private const val colDescription = "description"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = ("CREATE TABLE IF NOT EXISTS "
                            + Tbl_NAME + " ("
                            + col_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + colTitle + "TEXT,"
                            + colCode + "TEXT, "
                            + colCredit + "INTEGER, "
                            + colPrerequisites + "TEXT, "
                            + colDescription + "TEXT);")
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $Tbl_NAME")
        onCreate(db)
    }

    @SuppressLint("Range")
    fun getAllData(): ArrayList<Coursekey> {
        val clist: ArrayList<Coursekey> = ArrayList()
        val query = "SELECT * FROM $Tbl_NAME"
        val db = this.readableDatabase
        try {
            val cursor = db.rawQuery(query, null)
            if (cursor.moveToFirst()) {
                do {
                    val id = cursor.getInt(cursor.getColumnIndex(col_ID))
                    val title = cursor.getString(cursor.getColumnIndex(colTitle))
                    val code = cursor.getString(cursor.getColumnIndex(colCode))
                    val credit = cursor.getInt(cursor.getColumnIndex(colCredit))
                    val prereq = cursor.getString(cursor.getColumnIndex(colPrerequisites))
                    val description = cursor.getString(cursor.getColumnIndex(colDescription))
                    clist.add(Coursekey(id, title, code, credit, prereq, description))
                } while (cursor.moveToNext())
            }
            cursor.close()
            db.close()
        } catch (e: SQLiteException) {
           db.execSQL(query)
           return ArrayList()
        }
        return clist
    }

}
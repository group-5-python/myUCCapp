package com.example.myuccapp

import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.URLConnection


class UccCourse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ucc_course)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "IT Department Courses"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)


        // Declaring and Initializing
        val lvCourse = findViewById<ListView>(R.id.lvCourse)

        val db = DatabaseHelper(this)

        val courses = db.getAllData()

        val courseAdapter = MyCourseAdapter(this, courses)
        lvCourse.adapter = courseAdapter

        }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

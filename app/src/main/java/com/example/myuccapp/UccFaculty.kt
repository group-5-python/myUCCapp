package com.example.myuccapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class UccFaculty : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ucc_faculty)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Staff Directory"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)


        //Reads faculty list from items in strings.xml file
        val facultyList: Array<String> = resources.getStringArray(R.array.faculty)
        //Creates adapter that sets list type and list item
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, facultyList)

        val listView: ListView = findViewById(R.id.lvFaculty)
        //ListView control populated with list items
        listView.adapter = adapter

        //Defines action when list item is clicked
        listView.setOnItemClickListener { parent, view, position, id ->
            //Specifies which activity should be launched
            val intent = Intent(this, UccStaff::class.java)
            //Stores index number to be shared with Details activity
            intent.putExtra("listIndex", position.toString())
            //Starts activity
            this.startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}


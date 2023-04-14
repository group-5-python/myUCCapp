package com.example.myuccapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    // Declaring and Initializing
    lateinit var toggle: ActionBarDrawerToggle

    lateinit var navView: NavigationView
    lateinit var drawerLayout: DrawerLayout

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declaring and Initializing
        val uccWelcome: TextView = findViewById(R.id.welgreetings)


        drawerLayout = findViewById(R.id.drawerLayout)
        navView = findViewById(R.id.navView)


        toggle = ActionBarDrawerToggle( this@MainActivity,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Menu function
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_dir -> startActivity(Intent(this,UccFaculty::class.java))
                R.id.nav_course -> startActivity(Intent(this,UccCourse::class.java))
                R.id.nav_adm -> startActivity(Intent(this,Admission::class.java))
                R.id.nav_smedia -> startActivity(Intent(this,UccSocial::class.java))
                R.id.nav_etab -> startActivity(Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:ithod@ucc.edu.jm")))
            }
                true
        }


        // Display the welcome message to users
        uccWelcome.text="Welcome, student to the Information Technology Department APP." +
                "\nThis App consists of five department options where you can find details on:" +
                "\n ⦿ Staff Directory" +
                "\n ⦿ Courses " +
                "\n ⦿ Admission details" +
                "\n ⦿ Social Media Platforms" +
                "\n ⦿ Email Tab" +
                "\n" +
                "\nSelect the ☰ icon to navigate to each department options."
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
           return true
        }
        return super.onOptionsItemSelected(item)
    }
}

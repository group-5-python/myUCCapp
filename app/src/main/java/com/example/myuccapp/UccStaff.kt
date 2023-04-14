package com.example.myuccapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class UccStaff : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ucc_staff)


        //Gets value sent from Directory activity
        val index: String? = this.intent.getStringExtra("listIndex")

        //Creates objects for each activity element
        val name: TextView = findViewById(R.id.tvFName)
        val post: TextView = findViewById(R.id.tvFPost)
        val tel: TextView = findViewById(R.id.tvFPhone)
        val email: TextView = findViewById(R.id.tvFEmail)
        val photo: ImageView = findViewById(R.id.ivProfileImage)

        //Assigns value to elements according to retrieved index
        when(index){
            "0" -> {
                name.text = "Natalie, ROSE"
                post.text = "Head of IT Department/Lecturer"
                tel.text = "876-339-0961"
                email.text = "ithod@ucc.edu.jm"
                photo.setImageResource(R.drawable.nats)
            }
            "1" -> {
                name.text = "Cecil, WHITE"
                post.text = "Lecturer"
                tel.text = "876-428-3911"
                email.text = "cwhite01@faculty.ucc.edu.jm"
                photo.setImageResource(R.drawable.cw)
            }
            "2" -> {
                name.text = "Henry, OSBOURNE"
                post.text = "Lecturer"
                tel.text = "876-236-5458"
                email.text = "hosbourne@ucc.edu.jm"
                photo.setImageResource(R.drawable.ho)
            }
            "3" -> {
                name.text = "Damion, TOPPING"
                post.text = "Lecturer"
                tel.text = "876-421-3581"
                email.text = "dtopping@faculty.ucc.edu.jm"
                photo.setImageResource(R.drawable.dt)
            }
            "4" -> {
                name.text = "Stephen, GENTLES"
                post.text = "Lecturer"
                tel.text = "876-881-2980"
                email.text = "sgentles@faculty.ucc.edu.jm"
                photo.setImageResource(R.drawable.sg)
            }
            "5" -> {
                name.text = "Otis, OSBOURNE"
                post.text = "Lecturer/ Program Coordinator"
                tel.text = "876-513-6458"
                email.text = "itfaculty@ucc.edu.jm"
                photo.setImageResource(R.drawable.oo)
            }
            "6" -> {
                name.text = "Karen, WILSON"
                post.text = "Lecturer"
                tel.text = "876-364-4419"
                email.text = "itlecturer2@ucc.edu.jm"
                photo.setImageResource(R.drawable.karen)
            }
        }

        //Launches phone call when telephone number is tapped
        tel.setOnClickListener{
            val calintent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$tel"))
            startActivity(calintent)

        }

        //Launches email client when email address is tapped
        email.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email.toString(), null))
            intent.putExtra(Intent.EXTRA_EMAIL, email.toString())
            startActivity(intent)
        }
    }

}
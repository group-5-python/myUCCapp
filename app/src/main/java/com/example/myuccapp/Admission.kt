package com.example.myuccapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView

class Admission : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admission)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Admission Details"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        // Declaring and Initializing
        // the TextViews from the layout file

        val uccAbt: TextView = findViewById(R.id.tvAboutIntro)
        val uccLink: TextView = findViewById(R.id.ucclink)

        // Finding and displaying the content that consists a URL as a hyperlink
        uccLink.movementMethod = LinkMovementMethod.getInstance()


        uccAbt.text = "ENTRY REQUIREMENTS \n " +
                "To be unconditionally admitted to complete UCC undergraduate programmes, individuals should possess a " +
                "minimum of five (5) subjects at the GCE or CSEC level (including the mandatory English Language and Mathematics) " +
                "at grades A, B, C or 1, 2, 3 respectively. A CSEC pass at level 3 must have been obtained since 1998. " +
                "\n Candidates who have a minimum of 4 CXCs can also apply pending the outstanding CXC subjects " +
                "or can opt to do UCC replacement courses Core Mathematics, English for Academic Purpose and Fundamentals of Accounting. " +
                "\n Candidates can opt to apply under the Mature Entry option. To be accepted, applicants must be working for 5 years or " +
                "more and be at a minimum age of 25 years. Academic qualifications, a detailed resume, a job letter and 3 professional references will be required. \n" +
                "\n HONOURS PROGRAMME \n" +
                "Students with 8 CXC/GCE subjects including Mathematics and English Language at Grade 1 may be eligible for a 25% tuition waiver during the first year."
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
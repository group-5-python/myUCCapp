package com.example.myuccapp

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class MyCourseAdapter(context: Context, clist: ArrayList<Coursekey>) : ArrayAdapter<Coursekey>(context, 0, clist){

    // Function to retrieve all data from the database and place into listview
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.course_list, parent, false)
        }

        // Get the current course
        val courselist = getItem(position)


        // Bind the data to the view
        view?.findViewById<TextView>(R.id.ctitle)?.text = courselist?.title
        view?.findViewById<TextView>(R.id.ccode)?.text = courselist?.code
        view?.findViewById<TextView>(R.id.ccredits)?.text = courselist?.credit.toString()
        view?.findViewById<TextView>(R.id.cprereq)?.text = courselist?.prerequisites
        view?.findViewById<TextView>(R.id.cdescription)?.text = courselist?.description

        return view!!
        }
    }
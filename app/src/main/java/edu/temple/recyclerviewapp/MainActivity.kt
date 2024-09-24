package edu.temple.recyclerviewapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find layout (root element)
        val layout = findViewById<View>(R.id.layout)

        // Create array of color objects
        val colors = arrayOf(
            ColorObject("Red", "#FF0000"),
            ColorObject("Green", "#00FF00"),
            ColorObject("Blue", "#0000FF"),
            ColorObject("Gray", "#555555"),
            ColorObject("Yellow", "#FFFF00"),
            ColorObject("Pink", "#FFC0CB"),
            ColorObject("Orange", "#FFA500")
        )

        // lambda function which can now be called
        val myRecyclerViewFunc = {colorObject:ColorObject ->
            layout.setBackgroundColor(Color.parseColor(colorObject.code))
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Assign a Grid layout manager with 2 columns
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        // adapters accept lambda functions as the last arg, which can be done as such instead:
        /*recyclerView.adapter = ColorAdapter(colors) { colorObject:ColorObject ->
            layout.setBackgroundColor(Color.parseColor(colorObject.code)
        }
        */
        
        // Initialize adapter with lambda for event listening
        recyclerView.adapter = ColorAdapter(colors, myRecyclerViewFunc)


    }
}

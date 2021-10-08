package com.myapp.graph

import android.graphics.Color
import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.myapp.graph.Database.AppDatabase
import com.myapp.graph.Database.WeightData

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val db= AppDatabase.getInstance(this)


        val graphFragment = GraphFragment()
/*
         supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentlo, graphFragment)
            commit()
        }

 */


        supportFragmentManager
            .beginTransaction().apply {
            replace(R.id.fragmentlo, graphFragment)
            commit()
        }
        val enterWeight= findViewById<Button>(R.id.enterButton)
        val deleteData = findViewById<Button>(R.id.deleteButton)
        deleteData.setOnClickListener {
            db.weightDao().deleteAll();
            supportFragmentManager.beginTransaction().apply {
                val  gFragment = GraphFragment()

                replace(R.id.fragmentlo,gFragment)

                commit()
            }
        }
        /*
        enterWeight.setOnTouchListener { v, event ->
            true
        }


         */

        enterWeight.setOnClickListener {
            val weightText=findViewById<EditText>(R.id.weightText)
            val text = weightText.text
            val floated = text.toString().toFloat()
            db.weightDao().insertWeight(WeightData(0,floated))

               supportFragmentManager.beginTransaction().apply {
                   val  gFragment = GraphFragment()

                  replace(R.id.fragmentlo,gFragment)

                    commit()
            }



        }


    }
}

/*
private fun Button.setOnTouchListener() {
    TODO("Not yet implemented")
}
*/
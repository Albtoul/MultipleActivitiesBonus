package com.example.multipleactivitiesbonus

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog


class MainActivity2 : AppCompatActivity() {

    lateinit var tv: TextView
    lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        tv = findViewById(R.id.textView)
        button2 = findViewById(R.id.button2)

        tv.text = Info()

        button2.setOnClickListener {
            customAlert()
        }
    }

    private fun customAlert() {
        val dialogBuilder = AlertDialog.Builder(this)
        val tvAlert = TextView(this)
        tvAlert.text = Info()
        dialogBuilder.setMessage("is these the rigght information  ")
            .setPositiveButton("yes", DialogInterface.OnClickListener { _, _ ->
                val intent = Intent(this , MainActivity3::class.java)
                startActivity(intent)
            })
        val alert = dialogBuilder.create()
        alert.setView(tvAlert)
        alert.show()
    }
    private fun Info() : String{
        val Name = intent.getStringExtra("Name").toString()
        val Num = intent.getStringExtra("Age").toString()
        val Age = intent.getStringExtra("Num").toString()
        val Location = intent.getStringExtra("Location").toString()
        val info = "Name : ${Name}\n Num: ${Num} \n Age: ${Age} \n Location: ${Location}"
        return info
    }
}
package com.example.multipleactivitiesbonus

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var etName : EditText
    lateinit var etNum : EditText
    lateinit var etAge : EditText
    lateinit var etLocation : EditText
    lateinit var checkBox : CheckBox

    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etName)
        etNum = findViewById(R.id.etNum)
        etAge = findViewById(R.id.etAge)
        etLocation = findViewById(R.id.etLocation)
        checkBox = findViewById(R.id.checkBox)

        button = findViewById(R.id.button)

        button.setOnClickListener {

            if(checkBox.isChecked){
                openIntent()

            }
            else{
                customAlert()

            }
        }

    }

    private fun openIntent() {
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("Name", etName.text.toString())
        intent.putExtra("Num", etNum.text.toString())
        intent.putExtra("Age", etAge.text.toString())
        intent.putExtra("Location", etLocation.text.toString())
        startActivity(intent)
    }

    private fun customAlert() {
        val dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder.setMessage("please check the box: ")

            .setPositiveButton("OK",DialogInterface.OnClickListener {
                    _, _ ->
                Toast.makeText(this, "done", Toast.LENGTH_LONG).show()


            })
        val alert = dialogBuilder.create()
        alert.show()
    }
}
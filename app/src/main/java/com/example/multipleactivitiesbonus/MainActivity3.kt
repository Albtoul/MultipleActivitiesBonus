package com.example.multipleactivitiesbonus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity3 : AppCompatActivity() {
    private lateinit var rvMain: RecyclerView
    private lateinit var rvAdapter: RV
    private lateinit var info: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        info =  arrayListOf()
        rvMain = findViewById(R.id.rvMain)
        rvAdapter = RV(info)


        info.add(Info())

        rvMain.adapter = rvAdapter
        rvMain.layoutManager = LinearLayoutManager(this)
        rvMain.adapter?.notifyDataSetChanged()

    }
    private fun Info() : String{
        val Name = intent.getStringExtra("Name").toString()
        val Num = intent.getStringExtra("Age").toString()
        val Age = intent.getStringExtra("Num").toString()
        val Location = intent.getStringExtra("Location").toString()
        val info = "Name : ${Name}\n Num: ${Num} \n Age: ${Age} \n Location: ${Location}"
        return info
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.About ->{
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
                return true
            }

            R.id.Home ->{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
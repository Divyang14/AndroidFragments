package com.example.androidfragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.preference.PreferenceManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //add fragment to the activity
        //1 get the transation object
        val transaction = supportFragmentManager.beginTransaction()
        val listFrag = HotelFragment()
        transaction.add(R.id.parentL,listFrag)
        transaction.commit()

    }

    override fun onResume() {
        super.onResume()

        //what signature user has given
        //read preference
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val signature = pref.getString("signature","")
        Toast.makeText(this, "signature:$signature", Toast.LENGTH_LONG).show()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add("Login")
        menu?.add("Setting")
        menu?.add("Exit")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.title){
            "Setting"->{
                val transaction = supportFragmentManager.beginTransaction()
                val frag = SettingsFragment()
                transaction.replace(R.id.parentL, frag)
                
                transaction.addToBackStack(null)
                transaction.commit()
            }
            "Login"->{
                val i = Intent(this, LoginActivity::class.java)
                startActivity(i)
            }
            "Exit"->{
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
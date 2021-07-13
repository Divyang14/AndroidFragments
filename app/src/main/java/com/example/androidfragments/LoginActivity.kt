package com.example.androidfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }
    //(string,String) ->Unit
    private fun RegistrationDone(username:String, password:String){

        Toast.makeText(this,
            "Registration Done: $username, $password",Toast.LENGTH_LONG).show()

        //pass data to sign in fragment
        val transaction = supportFragmentManager.beginTransaction()
        val frag = SignInFragment.newInstance(username,password)
        transaction.replace(R.id.containerF,frag)
        transaction.commit()
    }

    fun buttonClick(view: View) {//for both buttons onclick method
        when(view.id){
            R.id.registerB ->{
                //display registration fragment
                //get a fragment transaction object (1)
                val transaction = supportFragmentManager.beginTransaction()
                //create fragment to be added(2)
                val frag = RegisterFragment(::RegistrationDone)//RegisterFragment class
                transaction.replace(R.id.containerF, frag)
                transaction.commit()

            }
            R.id.signB ->{
                //display sign_In fragment
                val transaction = supportFragmentManager.beginTransaction()
                //create fragment to be added(2)
//                val frag = SignInFragment()//RegisterFragment class
////
////                //we will use bundle to pass data from activity to fragment
////                val b = Bundle()
////                b.putString("uname", "DIVYANG")
////                b.putString("password","12345")
////                frag.arguments = b
////                //we will use bundle to pass data from activity to fragment

                val frag = SignInFragment.newInstance("divyang","123456789")

                transaction.replace(R.id.containerF, frag)

                //now for backstack//not mandatory
                transaction.addToBackStack(null)
                //now for backstack

                transaction.commit()

            }
        }
    }
}
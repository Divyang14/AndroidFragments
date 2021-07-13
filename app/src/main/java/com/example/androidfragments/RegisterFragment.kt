package com.example.androidfragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.setFragmentResult

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment(val callback:(String,String)->Unit ) : Fragment() {

    lateinit var submitButton : Button
    lateinit var unameEditText: TextView
    lateinit var passwordEditText: TextView
    lateinit var confirmPasswordEditText: TextView



    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("RegisterFragment", "OnAttach Called")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("RegisterFragment", "OnCreate Called")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("RegisterFragment", "OnCreateView Called")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("RegisterFragment", "OnViewCreated Called")
        super.onViewCreated(view, savedInstanceState)

        submitButton = view.findViewById(R.id.submitS)
        unameEditText = view.findViewById(R.id.unameE)
        passwordEditText = view.findViewById(R.id.passS)
        confirmPasswordEditText = view.findViewById(R.id.passconfE)

        submitButton.setOnClickListener{
            Toast.makeText(context, "Submit Clicked",Toast.LENGTH_LONG).show()
            val uname = unameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confPassword = confirmPasswordEditText.text.toString()

            validateData(uname, password, confPassword)
        }
    }

    private fun validateData(uname: String, password: String, confPassword: String) {
        if(uname.isNotEmpty() && password.isNotEmpty() && confPassword.isNotEmpty()){
            Toast.makeText(context,"Uname:$uname, password:$password", Toast.LENGTH_LONG).show()

            //send data username and password to that activity
//            callback(uname,password)
            val b = Bundle()
            b.putString("uname", uname)
            b.putString("password", password)
            setFragmentResult("registrationData", b)

        }
        else{
            Toast.makeText(context,"please provide all data", Toast.LENGTH_LONG).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("RegisterFragment", "OnStart Called")
    }

    override fun onResume() {
        //save data at any condition like onDestroy, onResume
        //it's called saving the state----sharedPreference
        super.onResume()
        Log.d("RegisterFragment", "OnResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("RegisterFragment", "OnPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("RegisterFragment", "OnStop Called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("RegisterFragment", "OnDestroyView Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("RegisterFragment", "OnDestroy Called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("RegisterFragment", "OnDetach Called")
    }
}
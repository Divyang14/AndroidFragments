package com.example.androidfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.setFragmentResultListener

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "uname"
private const val ARG_PARAM2 = "password"

/**
 * A simple [Fragment] subclass.
 * Use the [SignInFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignInFragment : Fragment() {

    lateinit var  uname: TextView
    lateinit var password: TextView
    lateinit var submitButton : Button

    // TODO: Rename and change types of parameters
    private var userName: String? = null
    private var passWord: String? = null
    private var userNameB: String? = null
    private var passWordB: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("registrationData"){requestKey, bundle ->

            userNameB = bundle.getString("uname")
            passWordB = bundle.getString("password")
            uname.setText(userNameB)
            password.setText(passWordB)

        }
        arguments?.let {
            userName = it.getString(ARG_PARAM1)
            passWord = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submitButton = view.findViewById(R.id.submitS)
        uname = view.findViewById(R.id.unameS)
        password = view.findViewById(R.id.passS)

//        val b = arguments
//        val userName = b?.getString("uname")
//        val passWord = b?.getString("password")

        uname.setText(userName)
        password.setText(passWord)


        submitButton.setOnClickListener{
            val uname = uname.text.toString()
            val password = password.text.toString()

            doSignIn(uname, password)
        }
    }

    private fun doSignIn(uname: String, password: String) {
        if(uname.isNotEmpty() && password.isNotEmpty()){
            Toast.makeText(context,"Uname:$uname, password:$password", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(context,"please provide all data", Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignInFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(userName: String, passWord: String) =
                SignInFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, userName)
                        putString(ARG_PARAM2, passWord)
                    }
                }
    }
}
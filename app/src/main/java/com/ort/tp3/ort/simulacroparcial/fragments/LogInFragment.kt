package com.ort.tp3.ort.simulacroparcial.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.ort.tp3.ort.simulacroparcial.R



class LogInFragment : Fragment() {
    private lateinit var userEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        val continueButton = view.findViewById<Button>(R.id.login_button)
        userEditText = view.findViewById(R.id.username_input)
        passwordEditText = view.findViewById(R.id.password_input)

        // Establezco un listener para escuchar cualquier click en el boton
        continueButton.setOnClickListener {

            // Navego hacia la home
            navController.navigate(
                LogInFragmentDirections.actionLoginFragmentToHomeFragment(
                    userEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            )
        }
    }

}
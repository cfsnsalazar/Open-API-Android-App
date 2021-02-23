package com.codingwithmitch.openapi.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.codingwithmitch.openapi.R
import kotlinx.android.synthetic.main.fragment_launcher.*

class LauncherFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_launcher, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        register.setOnClickListener {
            findNavController().navigate(R.id.action_launcherFragment_to_registerFragment)
        }
        login.setOnClickListener {
            findNavController().navigate(R.id.action_launcherFragment_to_loginFragment2)
        }
        forgot_password.setOnClickListener {
            findNavController().navigate(R.id.action_launcherFragment_to_forgotPasswordFragment)
        }
        focusable_view.requestFocus()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment LoginFragment.
         */
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}
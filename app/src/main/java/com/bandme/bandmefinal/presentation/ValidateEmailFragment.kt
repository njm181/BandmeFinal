package com.bandme.bandmefinal.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.bandme.bandmefinal.databinding.FragmentValidateEmailBinding
import com.bandme.bandmefinal.databinding.FragmentWelcomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.content.DialogInterface

import android.content.Intent

import android.R
import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider


class ValidateEmailFragment : Fragment() {

    private var _binding: FragmentValidateEmailBinding? = null
    private val binding get() = _binding!!

    //private val mainViewModel: MainViewModel by viewModel()
    var mainViewModel: MainViewModel? = null
    private var email: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel =  ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentValidateEmailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.validateEmail.setOnClickListener {
            email = binding.editTextTextEmailAddress.text.toString()
            mainViewModel?.validateEmail(email = email.toString())
        }

        mainViewModel?.validateEmailLiveData?.observe(viewLifecycleOwner, {
            Toast.makeText(requireContext(), "VALOOOOR: $it", Toast.LENGTH_SHORT).show()
            if(it == true) {
                //quiere login
                val bundle = bundleOf("email" to email)
                findNavController().navigate(com.bandme.bandmefinal.R.id.action_validateEmailFragment_to_validatePasswordFragment, bundle)
            } else {
                //necesita registro o ingreso mal el email
                popupAlert()
            }
        })
    }

    private fun popupAlert(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Atención")
        builder.setMessage("El email ingresado no existe o es incorrecto, si ya esta registrado vuelva a ingresarlo correctamente. Si no, puede registrarse ahora mismo.")
        builder.setPositiveButton("Registrarme"
        ) { dialog, id ->
            val bundle = Bundle()
            bundle.putString("email", email)
            bundle.putBoolean("isNewUser", true)
            findNavController().navigate(com.bandme.bandmefinal.R.id.action_validateEmailFragment_to_validatePasswordFragment, bundle)
            dialog.cancel()
        }

        builder.setNegativeButton("Volver a intentar"
        ) { dialog, id ->
            dialog.cancel()
        }

        builder.create().show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
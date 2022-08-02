package com.bandme.bandmefinal.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bandme.bandmefinal.R
import com.bandme.bandmefinal.databinding.FragmentValidatePasswordBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ValidatePasswordFragment : Fragment() {

//    private val mainViewModel: MainViewModel by viewModel()

    private var _binding: FragmentValidatePasswordBinding? = null
    private val binding get() = _binding!!
    private lateinit var email: String
    private var isNewUser: Boolean = false
    private lateinit var provider: String
    var mainViewModel: MainViewModel? = null

    //a esta pantalla solo deberian llegar los de logueo con email
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel =  ViewModelProvider(requireActivity())[MainViewModel::class.java]

        if (arguments?.getString("email") != null){
            email = arguments?.getString("email").orEmpty()
            if(arguments?.getBoolean("isNewUser") == true){
                isNewUser = true
                val prov = arguments?.getString("provider")
                provider = if(prov.isNullOrEmpty() ){
                    "EMAIL"
                }else{
                    prov
                }
            }
        }else{
            "999"
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentValidatePasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (isNewUser){
            binding.inputRepeatPassword.visibility = View.VISIBLE
        }

        binding.validatePassword.setOnClickListener {
            var password = binding.inputPassword.text.toString()
            println("PASSSWORDDD: $password")
            if (!isNewUser) {
                mainViewModel?.validateLogin(email = email, password = password)
            }else{
                //registro acumular, email, password si coinciden, ir a preguntar usertype y ya asignar el provider
                var repeatPassword = binding.inputRepeatPassword.text.toString()
                if(password == repeatPassword){
                    val bundle = Bundle()
                    bundle.putString("email", email)
                    bundle.putString("password", password)
                    bundle.putString("provider", provider)
                    bundle.putBoolean("isNewUser", isNewUser)
                    findNavController().navigate(R.id.action_validatePasswordFragment_to_userTypeFragment, bundle)
                }else{
                    Toast.makeText(requireContext(), "La contraseñas no coinciden", Toast.LENGTH_LONG).show()
                }
                //mainViewModel.validateLogin(email = email, password = password)
            }
        }

        mainViewModel?.validateLoginLiveData?.observe(viewLifecycleOwner, {
            if(it?.isAuthenticated == true && it?.jwt != "999"){
                //go to dashboard obtengo el token y lo guardo
                BaseApp.prefs.token = it.jwt
                println("TOKEN GUARDADO EN VALIDATE PASSWORD: " + BaseApp.prefs.token)
                findNavController().navigate(R.id.action_validatePasswordFragment_to_profileFragment)
            }
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
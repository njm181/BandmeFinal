package com.bandme.bandmefinal.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bandme.bandmefinal.R
import com.bandme.bandmefinal.databinding.FragmentUserTypeBinding
import com.bandme.bandmefinal.databinding.FragmentWelcomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserTypeFragment : Fragment() {

    private var _binding: FragmentUserTypeBinding? = null
    private val binding get() = _binding!!
    private lateinit var provider: String
    private lateinit var providerSocialMedia: String
    private lateinit var userType: String
    private lateinit var email: String
    private lateinit var password: String
    //private val mainViewModel: MainViewModel by viewModel()
    var mainViewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel =  ViewModelProvider(requireActivity())[MainViewModel::class.java]

        arguments?.getString("provider").let {
            if (!it.isNullOrEmpty()){
                provider = it
            }
        }
        arguments?.getString("providerSocialMedia").let {
            if (!it.isNullOrEmpty()){
                providerSocialMedia = it
            }
        }
        arguments?.getString("email").let {
            if (!it.isNullOrEmpty()){
                email = it
            }
        }
        arguments?.getString("password").let {
            if (!it.isNullOrEmpty()){
                password = it
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserTypeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel?.createAccountLiveData?.observe(viewLifecycleOwner, {
            it.let {
                if (it == true){
                    //a la pantalla del code y mandar email, aunque no lo vaya a usar por las dudas si despues modifico la api
                    val bundle = Bundle()
                    bundle.putString("email", email)
                    findNavController().navigate(R.id.action_userTypeFragment_to_authCodeFragment, bundle)
                }else{
                    Toast.makeText(requireContext(), "Ocurrió un error al crear la cuenta, por favor intente más tarde", Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding.btnArtista.setOnClickListener {
            userType = "ARTIST"
            mainViewModel?.creacteAccount(
                email = email,
                password = password,
                provider = provider,
                userType = userType
            )
        }

        binding.btnBanda.setOnClickListener {
            userType = "BAND"
            mainViewModel?.creacteAccount(
                email = email,
                password = password,
                provider = provider,
                userType = userType
            )
        }

        binding.btnLugar.setOnClickListener {
            userType = "PLACE"
            mainViewModel?.creacteAccount(
                email = email,
                password = password,
                provider = provider,
                userType = userType
            )
        }
    }





    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
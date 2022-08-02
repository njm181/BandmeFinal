package com.bandme.bandmefinal.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bandme.bandmefinal.R
import com.bandme.bandmefinal.databinding.FragmentProfileBinding
import com.bandme.bandmefinal.databinding.FragmentWelcomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    //private val mainViewModel: MainViewModel by viewModel()
    var mainViewModel: MainViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel =  ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("TOKEN GUARDADO: " + BaseApp.prefs.token)
        mainViewModel?.getUserProfile()
        mainViewModel?.getUserProfileLiveData?.observe(viewLifecycleOwner, {
            println("RESPUESTA DESDE PROFILE: $it")
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
package com.bandme.bandmefinal.presentation

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bandme.bandmefinal.R
import com.bandme.bandmefinal.databinding.FragmentAuthCodeBinding
import com.bandme.bandmefinal.databinding.FragmentUserTypeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthCodeFragment : Fragment() {

    private var _binding: FragmentAuthCodeBinding? = null
    private val binding get() = _binding!!
    //private val mainViewModel: MainViewModel by viewModel()
    var mainViewModel: MainViewModel? = null


    //private lateinit var sharedPreferences: SharedPreferences
    //private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
        //sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity)
        mainViewModel =  ViewModelProvider(requireActivity())[MainViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthCodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnVerificar.setOnClickListener {
            var code = binding.inputAuthCode.text.toString()
            mainViewModel?.confirmAccount(code = code)
        }

        mainViewModel?.confirmAccountLiveData?.observe(viewLifecycleOwner, {
            it.let {
                if (it?.isConfirm == true) {
                    println("RESPUESTA DE CONFIRMACION DE CUENTA: $it")
                    //guardar el jwt en un shared preferences
                    //editor.putString("jwt", it.jwt)
                    //println("TOKEN GUARDADO: "+ sharedPreferences.getString("jwt", ""))
                }else{
                    Toast.makeText(requireContext(), "Lo sentimos, no se pudo confirmar la cuenta, vuelva a intentarlo mas tarde", Toast.LENGTH_SHORT).show()
                }
            }
        })

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
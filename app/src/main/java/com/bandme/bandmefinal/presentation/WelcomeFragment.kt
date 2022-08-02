package com.bandme.bandmefinal.presentation

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bandme.bandmefinal.R
import com.bandme.bandmefinal.databinding.FragmentWelcomeBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    //private val mainViewModel: MainViewModel by viewModel()

    private val CONST_SIGN_IN = 100
    private val RC_SIGN_IN = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    //si es un registro con redes sociales despues de pegarle al servicio va directo a elegir el typo de usuario
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEmail.setOnClickListener {
            //mainViewModel.validateEmail("nicolasjmolina1@gmail.com")
            findNavController().navigate(R.id.action_welcomeFragment_to_validateEmailFragment)
            //cuando haya logueo con redes sociales y si es un registro usar val bundle = Bundle()
            //bundle.putString("isNewUser", true)
            //detectar que red social es, cuando se le pegue al servicio de la red que corresponda y cargar el provider
            //bundle.putString("providerSocialMEdia", "GMAIL/FACEBOOK")
            //bundle.putString("isNewUser", true)
        }

        /*binding.btnGoogle.setOnClickListener {
            googleSignIn()
        }*/
    }

    private fun getGoogleSinginClient() : GoogleSignInClient {
        /**
         * Configure sign-in to request the user's ID, email address, and basic
         * profile. ID and basic profile are included in DEFAULT_SIGN_IN.
         */
        val gso = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestIdToken("1068865243082-ggvt8si8bd6qg3k5jop853fuvaj0kkep.apps.googleusercontent.com")
            .requestProfile()
            .build()
        /**
         * Build a GoogleSignInClient with the options specified by gso.
         */
        return GoogleSignIn.getClient(requireContext(), gso);
    }

    private fun googleSignIn(){
        if (!isUserSignedIn()){
            val signInIntent = getGoogleSinginClient().signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        } else {
            val account = GoogleSignIn.getLastSignedInAccount(requireContext())
            Toast.makeText(requireContext(), "Usuario ya logueado: ${account?.idToken}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isUserSignedIn(): Boolean {
        val account = GoogleSignIn.getLastSignedInAccount(requireContext())
        return account != null
    }

    private fun signout() {
        if (isUserSignedIn()){
            getGoogleSinginClient().signOut().addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(requireContext(), " Signed out ", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), " Error ", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            handleSignData(data)
        }
        //callbackManager?.onActivityResult(requestCode, resultCode, data)
    }

    private fun handleSignData(data: Intent?) {
        // The Task returned from this call is always completed, no need to attach
        // a listener.
        GoogleSignIn.getSignedInAccountFromIntent(data)
            .addOnCompleteListener {
                //"isSuccessful ${it.isSuccessful}"
                if (it.isSuccessful){
                    // user successfully logged-in
                    val acc = it.result
                    println("ID TOKEN --> ${it.result?.idToken}")
                    println("ACCOUNT --> ${it.result?.account}")
                    println("DISPLAYNAME --> ${it.result?.displayName}")
                    println("EMAIL --> ${it.result?.email}")
                } else {
                    // authentication failed
                    "exception ${it.exception}"
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
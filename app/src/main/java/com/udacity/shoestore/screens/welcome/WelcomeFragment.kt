package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.WelcomeFragmentBinding


class WelcomeFragment : Fragment() {

    private lateinit var _binding: WelcomeFragmentBinding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = WelcomeFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.nextButton.setOnClickListener { view ->
            findNavController().navigate(
                WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment()
            )
        }
        return view
    }


}
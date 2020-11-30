package com.udacity.shoestore.screens.shoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {
    private lateinit var _binding: ShoeDetailFragmentBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ShoeDetailFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        val shoe = Shoe(
            binding.shoeNameInputText.text!!.toString(),
            binding.shoeSizeInputText.text!!.toString().toDouble(),
            binding.companyInputText.text!!.toString(),
            binding.descriptionInputText.text!!.toString()
        )
        binding.cancelButton.setOnClickListener { view ->
            findNavController().navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment3()
            )
        }
        binding.addButton.setOnClickListener { view ->
            findNavController().navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment3(shoe)
            )
        }
        return view
    }


}
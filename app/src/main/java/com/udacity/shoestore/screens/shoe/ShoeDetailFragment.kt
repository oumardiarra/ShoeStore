package com.udacity.shoestore.screens.shoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {
    private lateinit var _binding: ShoeDetailFragmentBinding
    private val binding get() = _binding

    private val viewModel by activityViewModels<ShoeListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ShoeDetailFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.cancelButton.setOnClickListener { view ->
            returnToList()
        }
        binding.shoe = viewModel
        viewModel.returnToList.observe(viewLifecycleOwner, Observer { shoulReturnToList ->
            if (shoulReturnToList)
                returnToList()

        })

        return view
    }

    fun returnToList() {
        findNavController().navigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.resetReturnList()
    }
}
package com.udacity.shoestore.screens.shoe

import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginTop
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.models.Shoe


class ShoeListFragment : Fragment() {

    private lateinit var _binding: ShoeListFragmentBinding
    private val binding get() = _binding!!
    private lateinit var viewModel: ShoeListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ShoeListFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        _binding.shoeListViewModel = viewModel
        viewModel.shoeList.observe(this, Observer { newShoe ->
            displayItem(newShoe)
        })
        val args = ShoeListFragmentArgs.fromBundle(arguments!!)
        viewModel.addShoeItem(args?.newShoe!!)
        displayItem(viewModel.shoeList.value!!)
        binding.floatingAcAdd.setOnClickListener { view ->
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }
        return view
    }

    private fun displayItem(shoeList: MutableList<Shoe>) {
        binding.shoeListLinearLayout.removeAllViews()
        shoeList?.forEach { shoe ->

            val textViewTitle = TextView(context)
            val shoeSizeText = TextView(context)
            val shoeCompanyText = TextView(context)
            //val dividerView = View(dividerContext)
            textViewTitle.text = shoe.name
            shoeSizeText.text = shoe.size.toString()
            shoeCompanyText.text = shoe.company

            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            /* params.setMargins(0, 10, 0, 10)
             textViewTitle.layoutParams = params*/
            binding.shoeListLinearLayout.addView(textViewTitle)
            binding.shoeListLinearLayout.addView(shoeSizeText)
            binding.shoeListLinearLayout.addView(shoeCompanyText)

        }
    }


}
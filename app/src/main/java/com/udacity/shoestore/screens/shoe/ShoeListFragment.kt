package com.udacity.shoestore.screens.shoe

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginTop
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.shoe_item_layout.view.*
import timber.log.Timber


class ShoeListFragment : Fragment() {

    private lateinit var _binding: ShoeListFragmentBinding
    private val binding get() = _binding!!

    private val viewModel by activityViewModels<ShoeListViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ShoeListFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        setHasOptionsMenu(true)
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { newShoe ->
            Timber.d("observer call")
            displayItem(viewModel.shoeList.value!!)
        })



        binding.floatingAcAdd.setOnClickListener { view ->
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }
        return view
    }

    private fun displayItem(shoeList: MutableList<Shoe>) {
        // binding.shoeListLinearLayout.removeAllViews()
        shoeList?.forEach { shoe ->
            val viewInflate = layoutInflater.inflate(R.layout.shoe_item_layout, null)
            viewInflate.shoe_name_text.text = shoe.name
            viewInflate.shoe_company_text.text = shoe.company
            viewInflate.shoe_size_text.text = shoe.size.toString()

            binding.shoeListLinearLayout.addView(viewInflate)


        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.menu,menu)
        //super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}
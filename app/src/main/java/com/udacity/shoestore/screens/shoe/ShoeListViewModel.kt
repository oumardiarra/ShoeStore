package com.udacity.shoestore.screens.shoe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList
    private var myShoeList = mutableListOf<Shoe>()

    init {
        createShoeList()
        _shoeList.value = myShoeList

    }

    private fun createShoeList() {
        myShoeList.add(
            Shoe(
                "Hiking Boots",
                36.0,
                "ZARA"
                ,
                "Hiking boots in a combination of materials and colours. Seven-eyelet facing with metallic lacing hooks. Hiking-style sole"
            )
        )
        myShoeList.add(
            Shoe(
                "Hiking Boots",
                36.0,
                "ZARA"
                ,
                "Hiking boots in a combination of materials and colours. Seven-eyelet facing with metallic lacing hooks. Hiking-style sole"
            )
        )
        myShoeList.add(
            Shoe(
                "Hiking Boots",
                36.0,
                "ZARA"
                ,
                "Hiking boots in a combination of materials and colours. Seven-eyelet facing with metallic lacing hooks. Hiking-style sole"
            )
        )
        myShoeList.add(
            Shoe(
                "Hiking Boots",
                36.0,
                "ZARA"
                ,
                "Hiking boots in a combination of materials and colours. Seven-eyelet facing with metallic lacing hooks. Hiking-style sole"
            )
        )
        myShoeList.add(
            Shoe(
                "Hiking Boots",
                36.0,
                "ZARA"
                ,
                "Hiking boots in a combination of materials and colours. Seven-eyelet facing with metallic lacing hooks. Hiking-style sole"
            )
        )
        myShoeList.add(
            Shoe(
                "Hiking Boots",
                36.0,
                "ZARA"
                ,
                "Hiking boots in a combination of materials and colours. Seven-eyelet facing with metallic lacing hooks. Hiking-style sole"
            )
        )
    }

    fun addShoeItem(shoe: Shoe) {
        myShoeList.add(shoe!!)
    }
}
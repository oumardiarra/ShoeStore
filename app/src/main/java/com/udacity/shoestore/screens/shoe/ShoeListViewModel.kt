package com.udacity.shoestore.screens.shoe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {
    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    private var _shoe = MutableLiveData<Shoe>()
    val shoe: LiveData<Shoe>
        get() = _shoe
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList
    private var myShoeList = mutableListOf<Shoe>()
    private var _returnToList = MutableLiveData<Boolean>()
    val returnToList: LiveData<Boolean> get() = _returnToList

    init {
        createShoeList()
        _shoeList.value = myShoeList
        _shoe.value = Shoe("", 0.0, "", "")
        _returnToList.value = false

    }

    private fun createShoeList() {
        myShoeList.add(
            Shoe(
                "Hiking Boots",
                36.0,
                "ZARA"
                ,
                "Hiking boots in a combination of materials and colours. " +
                        "Seven-eyelet facing with metallic lacing hooks. Hiking-style sole"
            )
        )
        myShoeList.add(
            Shoe(
                "Kinetix BOTTES HOMME - NOIR",
                36.0,
                "Kinetix"
                ,
                "Créée au début des années 60 dans un petit atelier à Gaziantep, une ville située dans le sud de la Turquie"
            )
        )
        myShoeList.add(
            Shoe(
                "Forester BOTTES HOMME - NOIR",
                36.0,
                "FORESTER"
                ,
                "Créée au début des années 60 dans un petit atelier à Gaziantep, une ville située dans le sud de la Turquie"
            )
        )
        myShoeList.add(
            Shoe(
                "Adidas Stan Smith -Black",
                41.0,
                "Adidas"
                ,
                "Hiking boots in a combination of materials and colours. Seven-eyelet facing with metallic lacing hooks. Hiking-style sole"
            )
        )
        myShoeList.add(
            Shoe(
                "Chekich Chaussure homme",
                30.0,
                "Chekich"
                ,
                "Affiche un style classique. Stan Smith a marqué son époque"
            )
        )
        myShoeList.add(
            Shoe(
                "Adidas Coast Star blanc/noir",
                26.0,
                "Adidas"
                ,
                "Affiche un style classique.  coast star  a marqué son époque."
            )
        )
    }


    fun addShoeItem() {
        Timber.d("Adding to new Shoe to the ShoeList")
        _shoeList.value?.add(_shoe.value!!)
        _returnToList.value = true
    }

    fun resetReturnList() {
        _returnToList.value = false
        _shoe.value = Shoe("", 0.0, "", "")
    }
}
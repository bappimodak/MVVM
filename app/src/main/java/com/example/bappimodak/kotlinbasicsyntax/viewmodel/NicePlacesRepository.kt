package com.example.bappimodak.kotlinbasicsyntax.viewmodel

import com.example.bappimodak.kotlinbasicsyntax.model.NicePlaces

class NicePlacesRepository {
    lateinit var mNicePlaces: ArrayList<NicePlaces>

    companion object {
        var nicePlacesRepository: NicePlacesRepository? = null
        fun getInstance(): NicePlacesRepository? {
            if (nicePlacesRepository == null) {
                nicePlacesRepository = NicePlacesRepository()
            }
            return nicePlacesRepository
        }
    }

    fun getCountryList(): MutableList<NicePlaces> {
        setNicePlaces()
        return mNicePlaces
    }

    fun setNicePlaces() {
        mNicePlaces = ArrayList()
        mNicePlaces.size
        mNicePlaces.add(NicePlaces("India", ""))
        mNicePlaces.add(NicePlaces("Australia", ""))
        mNicePlaces.add(NicePlaces("South Africa", ""))
        mNicePlaces.add(NicePlaces("Pakistan", ""))
        mNicePlaces.add(NicePlaces("Afghanistan", ""))
        mNicePlaces.add(NicePlaces("New Zealand", ""))
        mNicePlaces.add(NicePlaces("England", ""))
        mNicePlaces.add(NicePlaces("Sri Lanka", ""))
        mNicePlaces.add(NicePlaces("West Indies", ""))
        mNicePlaces.add(NicePlaces("Bangladesh", ""))
    }
}
package com.example.homeworkapplication.Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SeeViewModel:ViewModel() {
   private var stringtochange= MutableLiveData<String>()

    fun getstringtochange():LiveData<String>{
        return stringtochange    //getter for the object
    }

    /*init{
        stringtochange.value="Image"
    }*/

    fun updateString(){
        stringtochange.value="The Image"
    }

}
package com.example.minigame_lrud

import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel;
import timber.log.Timber
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class GameViewModel : ViewModel() {
    private lateinit var timer: CountDownTimer
    var millis : Long = 3
    var list = ArrayList<Int>(5)
    var mylist = ArrayList<Int>(5)
    var round :Int = 0
    var full :Boolean = false
    var  end :Boolean = false
    var  timeout :Boolean = false
    var boo : Boolean = false

    init {

        boo = false
        onRandom()
        Timber.i("GameViewModel created!")

    }

    private fun onRandom(){
        round=round+1
        for ( i in 1..6){
            list.add(Random.nextInt(1,5))
        }

    }



    fun setMyList(num:Int){
        if (mylist.size<5){
            mylist.add(num)
        }


    }

     fun checkstop (){
        if (mylist.size==5){
            if(mylist[0]==list[0]&&mylist[1]==list[1]&&mylist[2]==list[2]&&mylist[3]==list[3]&&mylist[4]==list[4]){

                list.clear()
                mylist.clear()
                onRandom()
                full = true

            }else{
                end=true
            }
        }else{
            end=true
        }
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("GameViewModel destroyed!")
    }
}

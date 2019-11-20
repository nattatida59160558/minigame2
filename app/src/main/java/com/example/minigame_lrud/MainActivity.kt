package com.example.minigame_lrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.minigame_lrud.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        val navController = this.findNavController(R.id.my_NavHostFragment)
        NavigationUI.setupActionBarWithNavController(this,navController)
        Timber.i("onCreate called")
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.my_NavHostFragment)
        return navController.navigateUp()
    }
    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart called")

    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume Called")

    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy Called")

    }

}

package com.example.minigame_lrud


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.minigame_lrud.databinding.FragmentAboutBinding


class AboutFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentAboutBinding>(inflater, R.layout.fragment_about,container,false)
        binding.txtAbout.text = "MINIGAME L R U D"
        binding.txtdetail.text = "เกมจำทิศทางลูกศรและกดตามให้ถูกต้อง"
        return return binding.root
    }


}

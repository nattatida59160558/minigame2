package com.example.minigame_lrud


import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.minigame_lrud.databinding.FragmentGameBinding
import java.util.*


class GameFragment : Fragment() {
    private lateinit var binding:FragmentGameBinding
    private lateinit var viewModel: GameViewModel
    var timer: Timer?=null
    val l:Long = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater, R.layout.fragment_game,container,false)
        val args = GameFragmentArgs.fromBundle(arguments!!)

        Toast.makeText(context, "${args.gameArgs}", Toast.LENGTH_LONG).show()
        Log.i("GameFragment", "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        // TODO: Use the ViewModel
        binding.txtRound.text = viewModel.round.toString()
        aa()
        binding.imageL.setOnClickListener { viewModel.setMyList(1)
        }
        binding.imageU.setOnClickListener { viewModel.setMyList(2) }
        binding.imageD.setOnClickListener { viewModel.setMyList(3) }
        binding.imageR.setOnClickListener { viewModel.setMyList(4) }
        binding.btnSubmit.setOnClickListener {view ->
            Toast.makeText(context, "${viewModel.mylist.size}", Toast.LENGTH_LONG).show()
            viewModel.checkstop()
            if(viewModel.full.equals(true)){
                binding.txtRound.text = viewModel.round.toString()
                viewModel.full = false
                aa()
            }else if(viewModel.end.equals(true)){
                view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToEndGameFragment(endArgs = "${viewModel.round-1}"))
            }
        }


        return binding.root
    }

    private fun startTimer(){
        timer = Timer(3000)
        timer?.start()
    }

    inner class Timer(miliis:Long) : CountDownTimer(miliis,1000){
        var millisUntilFinished:Long = 0
        override fun onFinish() {
            invisiblebutton()
        }

        override fun onTick(millisUntilFinished: Long) {
            this.millisUntilFinished = millisUntilFinished
            millisUntilFinished/1000




        }
    }



    private fun invisiblebutton(){
        binding.apply {
            item1.visibility= View.INVISIBLE
            item2.visibility= View.INVISIBLE
            item3.visibility= View.INVISIBLE
            item4.visibility= View.INVISIBLE
            item5.visibility= View.INVISIBLE
            timer?.cancel()
        }

    }

    private fun visiblebutton(){
        binding.apply {
            item1.visibility= View.VISIBLE
            item2.visibility= View.VISIBLE
            item3.visibility= View.VISIBLE
            item4.visibility= View.VISIBLE
            item5.visibility= View.VISIBLE
        }

    }






     private fun aa(){
        for (i in 0..4){
            if (viewModel.list[i]==1){
                if(i==0){
                    binding.item1.setImageResource(R.drawable.l)
                }else if(i==1){
                    binding.item2.setImageResource(R.drawable.l)
                }else if(i==2){
                    binding.item3.setImageResource(R.drawable.l)
                }else if(i==3){
                    binding.item4.setImageResource(R.drawable.l)
                }else if(i==4){
                    binding.item5.setImageResource(R.drawable.l)
                }

            }else if(viewModel.list[i]==2){
                if(i==0){
                    binding.item1.setImageResource(R.drawable.u)
                }else if(i==1){
                    binding.item2.setImageResource(R.drawable.u)
                }else if(i==2){
                    binding.item3.setImageResource(R.drawable.u)
                }else if(i==3){
                    binding.item4.setImageResource(R.drawable.u)
                }else if(i==4){
                    binding.item5.setImageResource(R.drawable.u)
                }
            }else if(viewModel.list[i]==3){
                if(i==0){
                    binding.item1.setImageResource(R.drawable.d)
                }else if(i==1){
                    binding.item2.setImageResource(R.drawable.d)
                }else if(i==2){
                    binding.item3.setImageResource(R.drawable.d)
                }else if(i==3){
                    binding.item4.setImageResource(R.drawable.d)
                }else if(i==4){
                    binding.item5.setImageResource(R.drawable.d)
                }
            }else if(viewModel.list[i]==4){
                if(i==0){
                    binding.item1.setImageResource(R.drawable.ri)
                }else if(i==1){
                    binding.item2.setImageResource(R.drawable.ri)
                }else if(i==2){
                    binding.item3.setImageResource(R.drawable.ri)
                }else if(i==3){
                    binding.item4.setImageResource(R.drawable.ri)
                }else if(i==4){
                    binding.item5.setImageResource(R.drawable.ri)
                }
            }
            startTimer()
            visiblebutton()

        }
    }


}

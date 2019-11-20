package com.example.minigame_lrud


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.minigame_lrud.databinding.FragmentEndGameBinding
import kotlinx.android.synthetic.main.fragment_end_game.*


class EndGameFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentEndGameBinding>(inflater, R.layout.fragment_end_game,container,false)
        val args = EndGameFragmentArgs.fromBundle(arguments!!)
        binding.txtScore.text = args.endArgs
        binding.btnAgain.setOnClickListener {view ->
            view.findNavController().navigate(EndGameFragmentDirections.actionEndGameFragmentToTitleFragment())
        }
        setHasOptionsMenu(true)
         return binding.root
    }
    private fun getShareIntent() : Intent {
        val args = EndGameFragmentArgs.fromBundle(arguments!!)
        val shareIntent = Intent(Intent.ACTION_SEND)
        var str = txtnamescore.text.toString()+" "+args.endArgs
        shareIntent.setType("text/plain")
                .putExtra(Intent.EXTRA_TEXT, str)
        return shareIntent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.winner_menu, menu)
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            menu?.findItem(R.id.share)?.setVisible(false)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }


}

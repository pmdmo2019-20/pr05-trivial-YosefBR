package es.iessaladillo.pedrojoya.pr05_trivial.fragments


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.play.PlayFragment
import kotlinx.android.synthetic.main.game_won_fragment.*

class GameWonFragment : Fragment(R.layout.game_won_fragment) {
    companion object {
        fun newInstance() = GameWonFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        setupAppBar()
        nextBtn.setOnClickListener{
            nextMatch()
        }
    }

    private fun setupAppBar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setTitle(R.string.game_won_imgYouWin)
        }
    }

    private fun nextMatch() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain, PlayFragment.newInstance())
            .commit()
    }
}

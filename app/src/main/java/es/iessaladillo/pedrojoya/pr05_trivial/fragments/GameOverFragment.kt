package es.iessaladillo.pedrojoya.pr05_trivial.fragments


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.play.PlayFragment
import kotlinx.android.synthetic.main.game_over_fragment.*

class GameOverFragment : Fragment(R.layout.game_over_fragment) {
    companion object {
        fun newInstance() = GameOverFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        setupAppBar()
        btnTryAgain.setOnClickListener {
            tryAgain()
        }
    }

    private fun setupAppBar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setTitle(R.string.game_over_title)
        }
    }

    private fun tryAgain() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain, PlayFragment.newInstance())
            .commit()
    }
}

package es.iessaladillo.pedrojoya.pr05_trivial.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.fragments.AboutFragment
import es.iessaladillo.pedrojoya.pr05_trivial.play.PlayFragment
import es.iessaladillo.pedrojoya.pr05_trivial.fragments.RulesFragment
import es.iessaladillo.pedrojoya.pr05_trivial.fragments.SettingsFragment
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        requireActivity().menuInflater.inflate(R.menu.trivial_activity, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.mnuRules -> {
                navigateToRules()
                true
            }
            R.id.mnuAbout -> {
                navigateToAbout()
                true
            }
            R.id.mnuSettings -> {
                navigateToSettings()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    private fun navigateToPlay() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain, PlayFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }


    private fun navigateToRules() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain, RulesFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    private fun navigateToAbout() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain, AboutFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    private fun navigateToSettings() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain, SettingsFragment())
            .addToBackStack(null)
            .commit()
    }

    private fun setupViews() {
        btnPlay.setOnClickListener {
            navigateToPlay()
        }
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(false)
            setTitle(R.string.main_title)
        }
    }

}

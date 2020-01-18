package es.iessaladillo.pedrojoya.pr05_trivial.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.fragments.AboutFragment
import es.iessaladillo.pedrojoya.pr05_trivial.fragments.RulesFragment
import es.iessaladillo.pedrojoya.pr05_trivial.fragments.SettingsFragment

class TrivialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trivial_activity)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain, MainFragment())
            .commit()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.trivial_activity, menu)
        return super.onCreateOptionsMenu(menu)
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

    private fun navigateToRules() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain, RulesFragment())
            .commit()
    }

    private fun navigateToAbout() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain, AboutFragment())
            .commit()
    }

    private fun navigateToSettings() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain, SettingsFragment())
            .commit()
    }
}
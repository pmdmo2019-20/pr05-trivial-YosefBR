package es.iessaladillo.pedrojoya.pr05_trivial.ui.main

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import es.iessaladillo.pedrojoya.pr05_trivial.R

class TrivialActivity : AppCompatActivity() {

    private val settings: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trivial_activity)
        if (savedInstanceState == null){
            showInitialDestination()
        }
    }

    private fun showInitialDestination() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain, MainFragment.newInstance())
            .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentById(R.id.fcMain)

        //Si el fragmento desde el que se pulsa el boton de back es "PlayFragment" y la opcion del dialog esta activada
        if (fragment.toString().substring(0, 12) == "PlayFragment" && settings.getBoolean("SwitchKey", true)) {
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.main_confirmation))
                .setMessage(getString(R.string.main_quit_game))
                .setPositiveButton(getString(R.string.main_yes)) { _, _ ->
                    super.onBackPressed()
                }
                    .setNegativeButton(getString(R.string.main_no)) { _, _ ->
                        //se mantiene en el fragmento
                    }
                        .show()
        }
        //Al pulsar el boton atras en el fragmento de ganador o perdedor, se vuelve a la pantalla principal
        else if (fragment.toString().substring(0, 16) == "GameOverFragment" || fragment.toString().substring(0, 15) == "GameWonFragment") {
            showInitialDestination()
        }
        else {
            super.onBackPressed()
        }
    }
}
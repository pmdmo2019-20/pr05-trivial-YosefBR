package es.iessaladillo.pedrojoya.pr05_trivial.play

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.base.Question
import es.iessaladillo.pedrojoya.pr05_trivial.base.questionList
import es.iessaladillo.pedrojoya.pr05_trivial.fragments.GameOverFragment
import es.iessaladillo.pedrojoya.pr05_trivial.fragments.GameWonFragment
import es.iessaladillo.pedrojoya.pr05_trivial.fragments.SettingsFragment
import kotlinx.android.synthetic.main.play_fragment.*

class PlayFragment : Fragment(R.layout.play_fragment) {

    private val viewModel: PlayFragmentViewModel by lazy {
        ViewModelProvider(this)
            .get(PlayFragmentViewModel::class.java)
    }

    private val settings: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(requireContext())
    }

    companion object {
        fun newInstance() = PlayFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        if (viewModel.questionsList == null) {
            viewModel.questionsList = questionList.shuffled().subList(0, settings.getInt("SeekKey",0))
        }
        putQuestion()
        setupAppBar()
        btnSubmit.setOnClickListener {
            checkAnswer()
        }
    }

    private fun putQuestion() {
        txtQuestion.text = viewModel.questionsList!![viewModel.currentQuestion].question
        rbtn1.text = viewModel.questionsList!![viewModel.currentQuestion].answers[0].answer
        rbtn2.text = viewModel.questionsList!![viewModel.currentQuestion].answers[1].answer
        rbtn3.text = viewModel.questionsList!![viewModel.currentQuestion].answers[2].answer
        rbtn4.text = viewModel.questionsList!![viewModel.currentQuestion].answers[3].answer
    }

    private fun checkAnswer() {
        val selected = radioGroup.checkedRadioButtonId
        //Primero se comprueba si se ha seleccionado una respuesta
        if (selected != -1) {
            //Si es correcta
            if (isCorrect()) {
                //Si es correcta y ademas es la ultima, has ganado
                if (viewModel.currentQuestion+1 == viewModel.questionsList!!.size) {
                    navigateToGameWon()
                }
                //Si es correcta pero no es la ultima, pasa a la siguiente
                else {
                    viewModel.currentQuestion++
                    putQuestion()
                    setupAppBar()
                }
            }
            //Si la respuesta no es correcta, pierdes
            else {
                navigateToGameOver()
            }
            radioGroup.clearCheck()
        }
    }

    private fun navigateToGameOver() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain, GameOverFragment.newInstance())
            .commit()
    }

    private fun navigateToGameWon() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain, GameWonFragment.newInstance())
            .commit()
    }

    private fun isCorrect (): Boolean {
        return (rbtn1.isChecked && viewModel.questionsList!![viewModel.currentQuestion].answers[0].correct)
                || (rbtn2.isChecked && viewModel.questionsList!![viewModel.currentQuestion].answers[1].correct)
                || (rbtn3.isChecked && viewModel.questionsList!![viewModel.currentQuestion].answers[2].correct)
                || (rbtn4.isChecked && viewModel.questionsList!![viewModel.currentQuestion].answers[3].correct)
    }

    private fun setupAppBar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            title = getString(R.string.game_question_title, viewModel.currentQuestion+1, getNumberOfQuestions())
        }
    }

    private fun getNumberOfQuestions(): Int {
        return settings.getInt("SeekKey", 0)
    }
}

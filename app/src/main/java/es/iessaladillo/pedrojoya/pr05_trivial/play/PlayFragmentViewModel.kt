package es.iessaladillo.pedrojoya.pr05_trivial.play

import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.pr05_trivial.base.Question

class PlayFragmentViewModel : ViewModel() {

    var currentQuestion = 0
    var questionsList: List<Question> ?= null
}
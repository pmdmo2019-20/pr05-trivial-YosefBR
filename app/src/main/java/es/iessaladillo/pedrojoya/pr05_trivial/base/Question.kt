package es.iessaladillo.pedrojoya.pr05_trivial.base

data class Answer(val answer: String, val correct: Boolean)
data class Question(val question: String, val answers: List<Answer>)

val q1a1 = Answer("Lola", true)
val q1a2 = Answer("Pepe", false)
val q1a3 = Answer("Maria", false)
val q1a4 = Answer("Nuño", false)

val q2a1 = Answer("Lola", true)
val q2a2 = Answer("Pepe", false)
val q2a3 = Answer("Maria", false)
val q2a4 = Answer("Nuño", false)

val q1answerList: List<Answer> = listOf(q1a1, q1a2, q1a3, q1a4)
val q2answerList: List<Answer> = listOf(q2a1, q2a2, q2a3, q2a4)

val q1 = Question("Un nombre", q1answerList)
val q2 = Question("Un apellido", q2answerList)

val questionList: List<Question> = listOf(q1, q2)
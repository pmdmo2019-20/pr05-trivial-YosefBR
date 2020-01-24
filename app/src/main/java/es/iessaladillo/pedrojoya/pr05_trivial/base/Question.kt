package es.iessaladillo.pedrojoya.pr05_trivial.base

data class Answer(val answer: String, val correct: Boolean)
data class Question(val question: String, val answers: List<Answer>)

//Respuestas para las diferentes preguntas *q + (numero de pregunta) + a + (numero de respuesta)*
val q1a1 = Answer("Thomas Edison", true)
val q1a2 = Answer("Nicola Tesla", false)
val q1a3 = Answer("Bethoven", false)
val q1a4 = Answer("Bruce Wayne", false)

val q2a1 = Answer("Alejandro Campos", false)
val q2a2 = Answer("Santiago de Alarcón", false)
val q2a3 = Answer("Rodrigo Díaz de Vivar", true)
val q2a4 = Answer("Júlio Rodriguez", false)

val q3a1 = Answer("O2", false)
val q3a2 = Answer("H4", false)
val q3a3 = Answer("CO2", false)
val q3a4 = Answer("H2O", true)

val q4a1 = Answer("Francisco de Quevedo", false)
val q4a2 = Answer("Sthepen King", true)
val q4a3 = Answer("García Lorca", false)
val q4a4 = Answer("Júlio Verne", false)

val q5a1 = Answer("Dodo", false)
val q5a2 = Answer("Baldosaurio Rex", false)
val q5a3 = Answer("Velociraptor", true)
val q5a4 = Answer("Mammoth", false)

val q6a1 = Answer("Bruno Mars", true)
val q6a2 = Answer("Dua Lipa", false)
val q6a3 = Answer("Beyonce", false)
val q6a4 = Answer("Shawn Mendes", false)

val q7a1 = Answer("Hora de Aventuras", false)
val q7a2 = Answer("Juego de Tronos", false)
val q7a3 = Answer("Vikings", false)
val q7a4 = Answer("The Witcher", true)

val q8a1 = Answer("Un raton", false)
val q8a2 = Answer("Un gato", true)
val q8a3 = Answer("Una coballa", false)
val q8a4 = Answer("Un cisne", false)

val q9a1 = Answer("que me mala", false)
val q9a2 = Answer("que me importe", false)
val q9a3 = Answer("que por bien no venga", true)
val q9a4 = Answer("que no me mate", false)

val q10a1 = Answer("Light Yagami", false)
val q10a2 = Answer("Midoriya Izuku", false)
val q10a3 = Answer("Senku Ishigami", false)
val q10a4 = Answer("Tanjiro Kamado", true)

//Lista con las respuestas para cada pregunta
val q1answerList: List<Answer> = listOf(q1a1, q1a2, q1a3, q1a4)
val q2answerList: List<Answer> = listOf(q2a1, q2a2, q2a3, q2a4)
val q3answerList: List<Answer> = listOf(q3a1, q3a2, q3a3, q3a4)
val q4answerList: List<Answer> = listOf(q4a1, q4a2, q4a3, q4a4)
val q5answerList: List<Answer> = listOf(q5a1, q5a2, q5a3, q5a4)
val q6answerList: List<Answer> = listOf(q6a1, q6a2, q6a3, q6a4)
val q7answerList: List<Answer> = listOf(q7a1, q7a2, q7a3, q7a4)
val q8answerList: List<Answer> = listOf(q8a1, q8a2, q8a3, q8a4)
val q9answerList: List<Answer> = listOf(q9a1, q9a2, q9a3, q9a4)
val q10answerList: List<Answer> = listOf(q10a1, q10a2, q10a3, q10a4)

//Preguntas
val q1 = Question("¿Quién fué el inventor de la bombilla?", q1answerList)
val q2 = Question("¿Cúal era el verdadero nombre del Cid?", q2answerList)
val q3 = Question("¿Cúal es la nomenclatura del agua?", q3answerList)
val q4 = Question("¿Quién es el escritor de la novela \"IT\"?", q4answerList)
val q5 = Question("¿Cúal de estos es un tipo de dinosaurio?", q5answerList)
val q6 = Question("¿Quien canta \"Uptown Funk\"?", q6answerList)
val q7 = Question("¿De qué serie es protagonista Geralt de Rivia?", q7answerList)
val q8 = Question("Doraemon es...", q8answerList)
val q9 = Question("Completa la frase: No hay mal que ________", q9answerList)
val q10 = Question("¿Cúal de estos es el protagonista del anime \"Kimetsu no yaiba\"?", q10answerList)

//Lista de preguntas
val questionList: List<Question> = listOf(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10)
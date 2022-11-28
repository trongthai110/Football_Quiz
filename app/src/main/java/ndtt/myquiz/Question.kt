package ndtt.myquiz

data class Question(
    val id: Int,
    val question: String,
    val image: Int,
    val answer1: String,
    val answer2: String,
    val answer3: String,
    val answer4: String,
    val correctAnswer: Int,
)

package ndtt.myquiz

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestion(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        // Question 1
        val que1 = Question(
            1,
            "Which national football team does this logo belong to?",
            R.drawable.ic_spain,
            "England national football team",
            "Spain national football team",
            "Portugal national football team",
            "Brazil national football team",
            2, // la cau hoi so 2
        )
        questionList.add(que1)

        // Question 2
        val que2 = Question(
            2,
            "Arsenal is based in which English city?",
            R.drawable.ic_arsenal,
            "Liverpool",
            "Manchester",
            "London",
            "Birmingham",
            3,
        )
        questionList.add(que2)

        // Question 3
        val que3 = Question(
            3,
            "What is the name of Atletico Madrid’s football stadium?",
            R.drawable.ic_atm,
            "Wanda Metropolitano",
            "Vicente Calderón",
            "Anfield",
            "Santiago Bernabeu",
            1,
        )
        questionList.add(que3)

        // Question 4
        val que4 = Question(
            4,
            "How many trophies did Barcelona win under Pep Guardiola?",
            R.drawable.ic_barca,
            "7",
            "16",
            "14",
            "17",
            3,
        )
        questionList.add(que4)

        // Question 5
        val que5 = Question(
            5,
            "Which manager won Chelsea’s first Premier League title?",
            R.drawable.ic_chelsea,
            "Ruud Gullit",
            "Carlo Ancelotti",
            "Avram Grant",
            "Jose Mourinho",
            4,
        )
        questionList.add(que5)

        // Question 6
        val que6 = Question(
            6,
            "In which country did France compete in its first world cup?",
            R.drawable.ic_french,
            "Switzerland",
            "Italia",
            "Brazil",
            "Uruguay",
            4,
        )
        questionList.add(que6)

        // Question 7
        val que7 = Question(
            7,
            "Who is currently the manager of Liverpool FC in the 2021-2022 season?",
            R.drawable.ic_liver,
            "Roy Hodgson",
            "Rafael Benitez",
            "Juergen Klopp",
            "Brendan Rogers",
            3,
        )
        questionList.add(que7)

        // Question 8
        val que8 = Question(
            8,
            "Who was the longest-tenured manager in Manchester United history?",
            R.drawable.ic_mu,
            "José Mourinho",
            "Alex Ferguson",
            "Ole Gunnar Solskjær",
            "David Moyes",
            2,
        )
        questionList.add(que8)

        // Question 9
        val que9 = Question(
            9,
            "Which Portuguese player scored against France in the Euro 2016 final?",
            R.drawable.ic_portugal,
            "Éder",
            "Cristiano Ronaldo",
            "Nani",
            "Renato Sanches",
            1,
        )
        questionList.add(que9)

        // Question 10
        val que10 = Question(
            10,
            "As of March 2020, how many times have Real Madrid won La Liga?",
            R.drawable.ic_real,
            "33",
            "34",
            "35",
            "36",
            1,
        )
        questionList.add(que10)

        return questionList
    }
}
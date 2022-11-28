package ndtt.myquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizActivity : AppCompatActivity(), View.OnClickListener {

    private var currentPosition: Int = 1
    private var questionList: ArrayList<Question>? = null
    private var selectedOptionPosition: Int = 0
    private var userName: String? = null
    private var correctAnswers: Int = 0

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var tvOption1: TextView? = null
    private var tvOption2: TextView? = null
    private var tvOption3: TextView? = null
    private var tvOption4: TextView? = null
    private var btnSubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        userName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.ivImage)

        tvOption1 = findViewById(R.id.tvOption1)
        tvOption2 = findViewById(R.id.tvOption2)
        tvOption3 = findViewById(R.id.tvOption3)
        tvOption4 = findViewById(R.id.tvOption4)
        btnSubmit = findViewById(R.id.btnSubmit)

        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        questionList = Constants.getQuestion()

        setQuestion()
        defaultOptionView()
    }

    private fun setQuestion() {
        defaultOptionView()
        val question: Question = questionList!![currentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = currentPosition
        tvProgress?.text = "$currentPosition / ${progressBar?.max}"
        tvQuestion?.text = question.question

        tvOption1?.text = question.answer1
        tvOption2?.text = question.answer2
        tvOption3?.text = question.answer3
        tvOption4?.text = question.answer4

        if (currentPosition == questionList!!.size) {
            btnSubmit?.text = "FINISH"
        } else {
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        tvOption1?.let {
            options.add(0, it)
        }
        tvOption2?.let {
            options.add(1, it)
        }
        tvOption3?.let {
            options.add(2, it)
        }
        tvOption4?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#2a3d45")) // dat mau chu, kieu chu, background mac dinh cho moi cau hoi
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_boder
            )
        }
    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum: Int) {
        defaultOptionView()

        selectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#2a3d45"))
        tv.setTypeface(tv.typeface, Typeface.BOLD) //in dam khi chon
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border
        )
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvOption1 -> {
                tvOption1?.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.tvOption2 -> {
                tvOption2?.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.tvOption3 -> {
                tvOption3?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.tvOption4 -> {
                tvOption4?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.btnSubmit -> {
                if (selectedOptionPosition == 0) {
                    currentPosition++

                    when {
                        currentPosition <= questionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, userName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, questionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = questionList?.get(currentPosition -1)
                    if (question!!.correctAnswer != selectedOptionPosition) {
                        answerView(selectedOptionPosition, R.drawable.incorrect_option_boder)
                    } else {
                        correctAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_boder)

                    if (currentPosition == questionList!!.size) {
                        btnSubmit?.text = "FINISH"
                    } else {
                        btnSubmit?.text = "NEXT QUESTION"
                    }

                    selectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tvOption1?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            2 -> {
                tvOption2?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            3 -> {
                tvOption3?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            4 -> {
                tvOption4?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}
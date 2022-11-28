package ndtt.myquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.btnStart)
        val etName : EditText = findViewById(R.id.etName)

        btnStart.setOnClickListener {

            if (etName.text.isEmpty()) {
                Toast.makeText(this,
                    "Please enter your name!", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, QuizActivity::class.java) // can phai them ::class.java sau activity
                intent.putExtra(Constants.USER_NAME, etName.text.toString())
                startActivity(intent) // di toi man hinh intent (QuizActivity)
                finish() // de dong man hinh Main (khong back duoc)
            }
        }
    }
}
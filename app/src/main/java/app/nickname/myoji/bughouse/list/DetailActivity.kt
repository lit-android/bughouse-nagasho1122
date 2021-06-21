package app.nickname.myoji.bughouse.list

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import app.nickname.myoji.bughouse.launcher.R


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val textView: TextView = findViewById(R.id.text_view)
        val backButton: Button = findViewById(R.id.back_button)

        val text = intent.getStringExtra("TASK_NAME")
        textView.text = text

        backButton.setOnClickListener {
            finish()
        }
    }
}

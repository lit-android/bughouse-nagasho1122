package app.nickname.myoji.bughouse.load

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import app.nickname.myoji.bughouse.launcher.R

class LoadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)

        val textView: TextView = findViewById(R.id.text_view)

        val sharedPreferences = getSharedPreferences("Second", Context.MODE_PRIVATE)
        textView.text = sharedPreferences.getString("SAVE", "")
    }
}

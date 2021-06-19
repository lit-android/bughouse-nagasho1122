package app.nickname.myoji.bughouse.save

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import app.nickname.myoji.bughouse.launcher.R

class SaveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)

        val input: EditText = findViewById(R.id.input)
        val saveButton: Button = findViewById(R.id.save_button)
        val sharedPreferences = getSharedPreferences("Second", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        saveButton.setOnClickListener {
            val text = input.text
            editor.putString("SAVE", text.toString())
        }
    }
}

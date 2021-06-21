package app.nickname.myoji.bughouse.launcher

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import app.nickname.myoji.bughouse.count.CountActivity
import app.nickname.myoji.bughouse.list.DetailActivity
import app.nickname.myoji.bughouse.list.ListActivity
import app.nickname.myoji.bughouse.load.LoadActivity
import app.nickname.myoji.bughouse.save.SaveActivity

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        val countActivityCell: LauncherCellView = findViewById(R.id.count_activity_cell)
        val saveActivityCell: LauncherCellView = findViewById(R.id.save_activity_cell)
        val loadActivityCell: LauncherCellView = findViewById(R.id.load_activity_cell)
        val listActivityCell: LauncherCellView = findViewById(R.id.list_activity_cell)

        countActivityCell.setOnClickListener {
            val intent = Intent(this, CountActivity::class.java)
            startActivity(intent)
        }

        saveActivityCell.setOnClickListener {
            val intent = Intent(this, SaveActivity::class.java)
            startActivity(intent)
        }

        loadActivityCell.setOnClickListener {
            val intent = Intent(this, LoadActivity::class.java)
            startActivity(intent)
        }
        listActivityCell.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }
}

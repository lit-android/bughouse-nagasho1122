package app.nickname.myoji.bughouse.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.nickname.myoji.bughouse.launcher.R


class ListActivity : AppCompatActivity() {
    private val taskList = mutableListOf(
        Task("Task 1"),
        Task("Task 2"),
        Task("Task 3")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val addButton: Button = findViewById(R.id.add_button)
        val editText: EditText = findViewById(R.id.edit_text)

        val adapter = TaskAdapter(this, object: TaskAdapter.ItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@ListActivity, DetailActivity::class.java)
                intent.putExtra("TASK_NAME", taskList[position].name)
                startActivity(intent)
            }
        })

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.addAll(taskList)

        addButton.setOnClickListener {
            val name = editText.text.toString()
            val addlist = mutableListOf(Task(name))
            taskList.add(Task(name))
            adapter.addAll(addlist)
        }
    }
}

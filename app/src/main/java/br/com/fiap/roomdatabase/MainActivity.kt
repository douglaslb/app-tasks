package br.com.fiap.roomdatabase

import AppDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import br.com.fiap.roomdatabase.task.Task
import br.com.fiap.roomdatabase.task.TaskAdapter
import br.com.fiap.roomdatabase.task.TaskDao

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var recyclerView: RecyclerView
    private val taskAdapter = TaskAdapter()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Room.databaseBuilder(applicationContext, AppDatabase::class.java,
            "AppDatabase").build()

        editText = findViewById(R.id.editTextTarefa)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = taskAdapter
        recyclerView.layoutManager = GridLayoutManager(this,2)

        editText.setOnEditorActionListener { textView, actionId, keyEvent ->

            when(actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    insertTask()
                    true
                }
                else ->{
                    false
                }
            }
        }
    }

    private fun insertTask() {
        val item = Task(description = editText.text.toString())
         taskAdapter.addTask(item)
    }

}
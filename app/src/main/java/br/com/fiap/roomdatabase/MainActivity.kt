package br.com.fiap.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.roomdatabase.task.AppDatabase
import br.com.fiap.roomdatabase.task.Task
import br.com.fiap.roomdatabase.task.TaskAdapter
import br.com.fiap.roomdatabase.task.TaskDao

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var recyclerView: RecyclerView
    private val taskAdapter = TaskAdapter()

    private var taskDao: TaskDao? = null

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = AppDatabase.getDatabase(this)
        taskDao = database.taskDao()

        val tasks = taskDao!!.getAll()
        viewModel.getTasks(tasks)


        editText = findViewById(R.id.editTextTarefa)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = taskAdapter
        recyclerView.layoutManager = GridLayoutManager(this,2)

        editText.setOnEditorActionListener { textView, actionId, keyEvent ->

            when(actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    val task = Task(description = editText.text.toString())
                    editText.text = null
                    viewModel.createTask(task)
                    true
                }
                else ->{
                    false
                }
            }
        }


        viewModel.liveCreateTask.observe(this, Observer {
            taskAdapter.addTask(it)
            taskDao!!.insert(it)
        })

        viewModel.liveGetTasks.observe(this, Observer {
            taskAdapter.updateItems(it)
        })
    }



}
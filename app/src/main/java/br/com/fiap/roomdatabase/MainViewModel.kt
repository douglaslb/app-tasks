package br.com.fiap.roomdatabase

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.roomdatabase.task.Task

class MainViewModel : ViewModel(){
    val liveCreateTask = MutableLiveData<Task>()

    val liveGetTasks = MutableLiveData<List<Task>>()

    fun getTasks(tasks: List<Task>) {
        liveGetTasks.value = tasks
    }

    fun createTask(task: Task) {
        liveCreateTask.value = task
    }
}
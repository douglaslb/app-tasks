package br.com.fiap.roomdatabase.task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.roomdatabase.R

class TaskAdapter: RecyclerView.Adapter<TaskViewHolder>() {


    private var items = mutableListOf<Task>()

    fun updateItems(newItens: List<Task>) {
        items = newItens.toMutableList()
        notifyDataSetChanged()
    }

    fun addTask(newItem: Task) {
        items.add(newItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
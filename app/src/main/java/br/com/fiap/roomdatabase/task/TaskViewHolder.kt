package br.com.fiap.roomdatabase.task

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_task.view.*

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Task) {
       itemView.textViewTask.text = item.description

       itemView.buttonSettings.setOnClickListener {
           Toast.makeText(itemView.context, "Settings", Toast.LENGTH_SHORT).show()
       }
    }
}
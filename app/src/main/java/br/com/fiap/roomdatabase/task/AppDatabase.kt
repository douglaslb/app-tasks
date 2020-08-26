import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.fiap.roomdatabase.task.Task
import br.com.fiap.roomdatabase.task.TaskDao

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
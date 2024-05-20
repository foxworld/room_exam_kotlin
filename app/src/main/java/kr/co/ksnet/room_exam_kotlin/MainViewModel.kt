package kr.co.ksnet.room_exam_kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(application, AppDatabase::class.java, "todo-db")
        //.allowMainThreadQueries()
        .build()

    fun getAll(): LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }

    suspend fun insert(todo: Todo) {
        db.todoDao().insert(todo)
    }

    fun delete(todo: Todo) {
        db.todoDao().delete(todo)
    }
}
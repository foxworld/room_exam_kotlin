package kr.co.ksnet.room_exam_kotlin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
        var title : String
) {
        @PrimaryKey(autoGenerate = true) var id : Int = 0
}
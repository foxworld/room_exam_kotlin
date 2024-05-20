package kr.co.ksnet.room_exam_kotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.co.ksnet.room_exam_kotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val resultText = findViewById<TextView>(R.id.result_text)
        val todoEdit = findViewById<TextView>(R.id.todo_edit)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.viewModel = viewModel

//        viewModel.getAll().observe(this, Observer {
//            resultText.text = it.toString()
//        })

//        findViewById<Button>(R.id.add_button).setOnClickListener {
//            viewModel.insert(todoEdit.text.toString())
//            //resultText.text = db.todoDao().getAll().toString()
//        }


    }
}

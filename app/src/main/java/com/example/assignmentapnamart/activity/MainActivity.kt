package com.example.assignmentapnamart.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assignmentapnamart.R
import com.example.assignmentapnamart.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}
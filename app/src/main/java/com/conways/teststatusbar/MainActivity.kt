package com.conways.teststatusbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.conways.statusbar.StatusBar
import com.conways.statusbar.StatusBarHelper
import com.conways.statusbar.StatusBarType

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StatusBar(this)
            .apply {
                type = StatusBarType.Normal
                color=ContextCompat.getColor(this@MainActivity,R.color.colorAccent)
                isDarkModel=false
            }
            .commit()
    }
}
